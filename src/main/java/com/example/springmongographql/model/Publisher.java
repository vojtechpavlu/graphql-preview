package com.example.springmongographql.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class Publisher extends Taggable {

    @Id
    private String id;

    private String name;
    private String address;
    private String telephone;
}
