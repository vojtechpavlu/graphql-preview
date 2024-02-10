package com.example.springmongographql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Author {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer birthYear;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
