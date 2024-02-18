package com.example.springmongographql.repository;

import com.example.springmongographql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Tries to find all the books with assigned publisher ID
     */
    List<Book> findBooksByPublisherId(String publisherId);

    /**
     * Tries to find all the books of the given author
     */
    List<Book> findAllByAuthorIdsContaining(String authorId);
}
