package com.example.azurecosmosdb.model;


import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "customers")
@Data
@ToString

public class Customer {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
}


