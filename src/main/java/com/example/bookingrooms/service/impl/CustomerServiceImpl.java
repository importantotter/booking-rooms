package com.example.bookingrooms.service.impl;

import com.example.bookingrooms.dto.CustomerDto;
import com.example.bookingrooms.dto.converter.CustomerConverter;
import com.example.bookingrooms.model.Customer;
import com.example.bookingrooms.exception.CustomerNotFoundException;
import com.example.bookingrooms.repositories.CustomerRepository;
import com.example.bookingrooms.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /*@Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );
    }*/

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).get();
        return customerConverter.convertToDto(customer);
    }

    @Override
    public Customer updateCustomer(long id, Customer newCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );

        handleCustomerUpdate(customer, newCustomer);
        customerRepository.save(customer);
        return customer;
    }

    private void handleCustomerUpdate(Customer customer, Customer newCustomer) {
        customer.setEmail(newCustomer.getEmail());
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customer.setRole(newCustomer.getRole());
        customer.setPassword(newCustomer.getPassword());
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(0, 10));
        return customers.toList();
    }
}
