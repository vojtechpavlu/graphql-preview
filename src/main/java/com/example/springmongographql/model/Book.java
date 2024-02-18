package com.example.springmongographql.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Book extends Taggable {

    @Id
    private String id;

    private String title;
    private Integer year;
    private String publisherId;
    private List<String> authorIds;
}
