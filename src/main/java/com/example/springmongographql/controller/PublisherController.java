package com.example.springmongographql.controller;

import com.example.springmongographql.model.Book;
import com.example.springmongographql.model.Publisher;
import com.example.springmongographql.model.Tag;
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
public class PublisherController {

    private final PublisherService publisherService;
    private final BookService bookService;
    private final TagService tagService;

    /**
     * Resolver for all the publishers
     */
    @QueryMapping(name = "allPublishers")
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    /**
     * Resolved for getting publisher by his ID
     */
    @QueryMapping(name = "publisherById")
    public Optional<Publisher> getPublisherById(@Argument String id) {
        return publisherService.getPublisherById(id);
    }

    /**
     * Custom populator for publisher's books
     */
    @SchemaMapping(typeName = "Publisher", field = "books")
    public List<Book> populateBooks(Publisher publisher) {
        System.out.println("Populating publisher's books");
        return bookService.getBooksOfPublisher(publisher.getId());
    }

    /**
     * Custom populator for publisher's number of books
     */
    @SchemaMapping(typeName = "Publisher", field = "numberOfBooks")
    public Integer populateNumberOfBooks(Publisher publisher) {
        System.out.println("Populating publisher's books count");
        return bookService.getBooksOfPublisher(publisher.getId()).size();
    }

    /**
     * Custom populator of tags
     */
    @SchemaMapping(typeName = "Publisher", field = "tags")
    public List<Tag> populateTags(Publisher publisher) {
        System.out.println("Populating publisher's tags");
        return tagService.getMultipleTags(publisher.getTagIds());
    }
}
