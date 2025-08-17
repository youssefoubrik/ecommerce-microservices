package com.oubrik.ecommerce.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }

        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(toAddress(request.address()))
                .build();
    }

    public CustomerRequest toCustomerRequest(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new CustomerRequest(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                toAddressDto(customer.getAddress()));
    }

    private Address toAddress(AddressRequest dto) {
        if (dto == null) {
            return null;
        }
        return Address.builder()
                .street(dto.street())
                .houseNumber(dto.houseNumber())
                .zipCode(dto.zipCode())
                .build();
    }

    private AddressRequest toAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressRequest(
                address.getStreet(),
                address.getHouseNumber(),
                address.getZipCode());
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                toAddressDto(customer.getAddress()));
    }
}
