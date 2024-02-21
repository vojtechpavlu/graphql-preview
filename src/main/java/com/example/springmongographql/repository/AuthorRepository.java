package com.example.springmongographql.repository;

import com.example.springmongographql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    /**
     * Gets the list of author instances by given list of IDs
     * Enables batching - returning multiple instances by list of IDs.
     */
    List<Author> findAllByIdIn(List<String> ids);

    /**
     * Gets the list of authors with given tag assigned.
     * Every author has a list of IDs dedicated to Tags.
     */
    List<Author> findAllByTagIdsContaining(String tagId);
}
