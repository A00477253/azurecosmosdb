package com.example.azurecosmosdb.contoller;



import com.example.azurecosmosdb.model.Customer;
import com.example.azurecosmosdb.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {


    @Autowired
     private CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            log.debug("The customer object is "+customer);
            Customer savedCustomer = customerService.createCustomer(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            log.debug("The exception message is "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers =  StreamSupport
                    .stream(customerService.getAllCustomers().spliterator(), false)
                    .collect(Collectors.toList());
            log.debug("The list is "+customers.size());

            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

