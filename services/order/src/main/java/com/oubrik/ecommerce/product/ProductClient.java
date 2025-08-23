package com.oubrik.ecommerce.product;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oubrik.ecommerce.exception.ProductClientException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${spring.application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<List<ProductPurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<ProductPurchaseResponse>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<ProductPurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType);
        if (responseEntity.getStatusCode().isError()) {
            throw new ProductClientException(
                    "Failed to purchase products. Status code: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
