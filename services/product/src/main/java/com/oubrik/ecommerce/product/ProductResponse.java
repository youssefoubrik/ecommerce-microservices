package com.oubrik.ecommerce.product;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    Integer id;
    String name;
    String description;
    double availableQuantity;
    BigDecimal price;
    Integer categoryId;
    String categoryName;
    String categoryDescription;
}
