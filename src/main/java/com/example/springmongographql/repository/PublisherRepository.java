package com.example.springmongographql.repository;

import com.example.springmongographql.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublisherRepository extends MongoRepository<Publisher, String> {

    /**
     * Gets the list of publishers with given tag assigned.
     * Every publisher has a list of IDs dedicated to Tags.
     */
    List<Publisher> findAllByTagIdsContaining(String tagId);
}
