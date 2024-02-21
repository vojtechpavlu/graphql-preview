package com.example.springmongographql.controller;

import com.example.springmongographql.model.Author;
import com.example.springmongographql.model.Book;
import com.example.springmongographql.model.Publisher;
import com.example.springmongographql.model.Tag;
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
public class TagController {

    private final TagService tagService;

    /**
     * Resolver for retrieving all the tags
     */
    @QueryMapping(name = "allTags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    /**
     * Resolver for retrieving the tag by ID
     */
    @QueryMapping(name = "tagById")
    public Optional<Tag> getTagByID(@Argument String id) {
        return tagService.getTagById(id);
    }

    /**
     * Custom populator of books with assigned tag
     */
    @SchemaMapping(typeName = "Tag", field = "books")
    public List<Book> populateBooks(Tag tag) {
        System.out.println("Populating books with tag");
        return tagService.getAllBooksWithTag(tag.getId());
    }

    /**
     * Custom populator of publishers with assigned tag
     */
    @SchemaMapping(typeName = "Tag", field = "publishers")
    public List<Publisher> populatePublishers(Tag tag) {
        System.out.println("Populating publishers with tag");
        return tagService.getAllPublishersWithTag(tag.getId());
    }

    /**
     * Custom populator of authors with assigned tag
     */
    @SchemaMapping(typeName = "Tag", field = "authors")
    public List<Author> populateAuthors(Tag tag) {
        System.out.println("Populating authors with tag");
        return tagService.getAllAuthorsWithTag(tag.getId());
    }
}
