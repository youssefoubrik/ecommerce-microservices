package com.oubrik.ecommerce.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oubrik.ecommerce.exception.InsufficientQuantityException;
import com.oubrik.ecommerce.exception.ProductNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRespository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    @Transactional
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {

        var productIds = request.stream()
                .map(ProductPurchaseRequest::productId)
                .distinct()
                .collect(Collectors.toList());

        var products = productRepository.findAllById(productIds);

        var productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        for (ProductPurchaseRequest purchaseRequest : request) {
            if (!productMap.containsKey(purchaseRequest.productId())) {
                throw new ProductNotFoundException("Product not found with ID: " + purchaseRequest.productId());
            }

            Product product = productMap.get(purchaseRequest.productId());
            if (product.getAvailableQuantity() < purchaseRequest.quantity()) {
                String errorMessage = String.format(
                        "Insufficient quantity for product %s (ID: %d). Requested: %.2f, Available: %d",
                        product.getName(), product.getId(), purchaseRequest.quantity(), product.getAvailableQuantity());
                throw new InsufficientQuantityException(errorMessage);
            }
        }

        List<ProductPurchaseResponse> responses = new ArrayList<>();
        for (ProductPurchaseRequest purchaseRequest : request) {
            Product product = productMap.get(purchaseRequest.productId());

            product.setAvailableQuantity(product.getAvailableQuantity() - purchaseRequest.quantity());

            var totalPrice = product.getPrice().multiply(BigDecimal.valueOf(purchaseRequest.quantity()));

            responses.add(new ProductPurchaseResponse(
                    product.getId(),
                    product.getName(),
                    purchaseRequest.quantity(),
                    product.getPrice(),
                    totalPrice));
        }

        productRepository.saveAll(productMap.values());

        return responses;
    }

    public ProductResponse getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product not found with ID: " + productId));
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
