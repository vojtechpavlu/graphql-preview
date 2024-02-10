package com.example.springmongographql.repository;

import com.example.springmongographql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findBooksByPublisherId(String publisherId);

    List<Book> findAllByAuthorIdsContaining(String authorId);
}
