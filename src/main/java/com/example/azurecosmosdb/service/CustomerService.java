package com.example.azurecosmosdb.service;

import com.example.azurecosmosdb.model.Customer;
import com.example.azurecosmosdb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    public Customer createCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create customer", e);
        }
    }



}

