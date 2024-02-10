package com.example.springmongographql.controller;

import com.example.springmongographql.model.Author;
import com.example.springmongographql.model.Book;
import com.example.springmongographql.service.AuthorService;
import com.example.springmongographql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    /**
     * Resolver for all the authors
     */
    @QueryMapping(name = "allAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    /**
     * Resolver for getting an author by his ID
     */
    @QueryMapping(name = "authorById")
    public Optional<Author> getAuthorById(@Argument String id) {
        return authorService.getAuthorById(id);
    }

    /**
     * Custom populator of author's books
     */
    @SchemaMapping(typeName = "Author", field = "books")
    public List<Book> populateBooks(Author author) {
        System.out.println("Populating author's books");
        return bookService.getBooksOfAuthor(author.getId());
    }

    /**
     * Custom populator of author's full name
     */
    @SchemaMapping(typeName = "Author", field = "fullName")
    public String populateFullName(Author author) {
        System.out.println("Populating author's full name");
        return String.format("%s %s", author.getFirstName(), author.getLastName());
    }

    /**
     * Custom populator of author's age
     */
    @SchemaMapping(typeName = "Author", field = "age")
    public Integer populateAge(Author author) {
        System.out.println("Populating author's age");
        int currentYear = Year.now().getValue();
        return currentYear - author.getBirthYear();
    }

    /**
     * Custom populator of books count
     */
    @SchemaMapping(typeName = "Author", field = "numberOfBooks")
    public Integer populateNumberOfBooks(Author author) {
        System.out.println("Populating author's book count");
        return bookService.getBooksOfAuthor(author.getId()).size();
    }
}
