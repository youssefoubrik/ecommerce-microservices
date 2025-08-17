package com.oubrik.ecommerce.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressRequest(
                @NotBlank(message = "Street is required") @Size(min = 2, max = 100, message = "Street must be between 2 and 100 characters") String street,

                @NotBlank(message = "House number is required") @Size(max = 10, message = "House number must be at most 10 characters") String houseNumber,

                @NotBlank(message = "Zip code is required") @Pattern(regexp = "^[0-9]{5}(-[0-9]{4})?$", message = "Zip code must be valid (e.g. 12345 or 12345-6789)") String zipCode) {
}
