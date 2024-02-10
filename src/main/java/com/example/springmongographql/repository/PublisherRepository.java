package com.example.springmongographql.repository;

import com.example.springmongographql.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher, String> {
}
