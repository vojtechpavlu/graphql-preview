package com.example.springmongographql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Book {

    @Id
    private String id;

    private String title;
    private Integer year;
    private String publisherId;
    private List<String> authorIds;

    public Book(String title, Integer year, String publisherId, List<String> authorIds) {
        this.title = title;
        this.year = year;
        this.publisherId = publisherId;
        this.authorIds = authorIds;
    }
}
