package com.example.bookingrooms.controller;

import com.example.bookingrooms.dto.CustomerDto;
import com.example.bookingrooms.model.Customer;
import com.example.bookingrooms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('create')")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable("id") long customerId) {
        return customerService.getCustomerById(customerId);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('update')")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable("id") long customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCustomer(@PathVariable("id") long customerId) {
        customerService.deleteCustomer(customerId);
        return("Customer deleted successfully");
    }
}
