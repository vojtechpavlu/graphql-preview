package com.example.springmongographql.controller;

import com.example.springmongographql.model.Author;
import com.example.springmongographql.model.Book;
import com.example.springmongographql.model.Publisher;
import com.example.springmongographql.model.Tag;
import com.example.springmongographql.service.AuthorService;
import com.example.springmongographql.service.BookService;
import com.example.springmongographql.service.PublisherService;
import com.example.springmongographql.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final TagService tagService;

    /**
     * Resolver for all the books
     */
    @QueryMapping(name = "allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Resolver for getting a book by its ID
     */
    @QueryMapping(name = "bookById")
    public Optional<Book> getBookById(@Argument String id) {
        return bookService.getBookById(id);
    }

    /**
     * Custom populator of book's publisher
     */
    @SchemaMapping(typeName = "Book", field = "publisher")
    public Optional<Publisher> populatePublisher(Book book) {
        System.out.println("Populating book's publisher");
        return publisherService.getPublisherById(book.getPublisherId());
    }

    /**
     * Custom populator of book's authors
     */
    @SchemaMapping(typeName = "Book", field = "authors")
    public List<Author> populateAuthors(Book book) {
        System.out.println("Populating book's author");
        return authorService.getMultipleAuthors(book.getAuthorIds());
    }

    /**
     * Custom populator of book's authors count
     */
    @SchemaMapping(typeName = "Book", field = "numberOfAuthors")
    public Integer populateAuthorsCount(Book book) {
        System.out.println("Populating book's author count");
        return authorService.getMultipleAuthors(book.getAuthorIds()).size();
    }

    /**
     * Custom populator of tags
     */
    @SchemaMapping(typeName = "Book", field = "tags")
    public List<Tag> populateTags(Book book) {
        System.out.println("Populating book's tags");
        return tagService.getMultipleTags(book.getTagIds());
    }
}
