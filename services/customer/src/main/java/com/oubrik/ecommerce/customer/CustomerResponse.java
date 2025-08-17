package com.oubrik.ecommerce.customer;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        AddressRequest address) {
}
