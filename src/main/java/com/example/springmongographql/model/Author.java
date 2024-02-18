package com.example.springmongographql.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Author extends Taggable {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer birthYear;
}
