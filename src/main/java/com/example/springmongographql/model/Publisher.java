package com.example.springmongographql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Publisher {

    @Id
    private String id;

    private String name;
    private String address;
    private String telephone;

    public Publisher(String name, String address, String telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
}
