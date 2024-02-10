package com.example.springmongographql.repository;

import com.example.springmongographql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    List<Author> findAllByIdIn(List<String> ids);
}
