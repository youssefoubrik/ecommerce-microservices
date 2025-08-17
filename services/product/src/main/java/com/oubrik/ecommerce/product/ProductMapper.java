package com.oubrik.ecommerce.product;

import org.springframework.stereotype.Service;

import com.oubrik.ecommerce.category.Category;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(request.categoryId() != null ? Category.builder().id(request.categoryId()).build() : null)
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .categoryDescription(product.getCategory() != null ? product.getCategory().getDescription() : null)
                .build();
    }

}
