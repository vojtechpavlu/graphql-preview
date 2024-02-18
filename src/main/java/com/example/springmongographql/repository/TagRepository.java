package com.example.springmongographql.repository;

import com.example.springmongographql.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {

    /**
     * Tries to find all the tags by a given list of IDs
     */
    List<Tag> findAllByIdIn(List<String> ids);
}
