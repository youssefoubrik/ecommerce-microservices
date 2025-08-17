package com.oubrik.ecommerce.customer;

import static java.lang.String.format;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.oubrik.ecommerce.exception.CustomerNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        return repository.save(mapper.toCustomer(request)).getId();
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = repository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
                format("Cannot update customer: No customer found with the provided ID: %s", request.id())));
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());

        AddressRequest addressRequest = request.address();
        Address address = customer.getAddress();

        address.setStreet(addressRequest.street());
        address.setHouseNumber(addressRequest.houseNumber());
        address.setZipCode(addressRequest.zipCode());
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll().stream().map((mapper::toCustomerResponse)).collect(Collectors.toList());
    }

    public boolean isCustomerPresent(String customerId) {
        return repository.existsById(customerId);
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId).map(mapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Customer not found with ID: %s", customerId)));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
