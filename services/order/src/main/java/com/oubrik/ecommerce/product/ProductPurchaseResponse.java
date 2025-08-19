package com.oubrik.ecommerce.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
                Integer productId,
                String productName,
                double quantity,
                BigDecimal unitPrice,
                BigDecimal totalPrice) {

}
