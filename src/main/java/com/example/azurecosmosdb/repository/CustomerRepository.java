package com.example.azurecosmosdb.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.azurecosmosdb.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CosmosRepository<Customer, String> {
}
