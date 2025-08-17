package com.oubrik.ecommerce.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
        String id,
        @NotBlank(message = "Customer firstname is required") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName,

        @NotBlank(message = "Customer lastname is required") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName,

        @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email,

        @Valid @NotNull(message = "Address is required") AddressRequest address) {
}
