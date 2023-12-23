package com.example.bookingrooms.service;

import com.example.bookingrooms.dto.CustomerDto;
import com.example.bookingrooms.model.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    CustomerDto getCustomerById(long id);
    Customer updateCustomer(long id, Customer customer);
    void deleteCustomer(long id);
    List<Customer> getAllCustomers();
}
