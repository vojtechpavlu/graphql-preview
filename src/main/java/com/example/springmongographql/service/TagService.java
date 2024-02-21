package com.example.springmongographql.service;

import com.example.springmongographql.model.Author;
import com.example.springmongographql.model.Book;
import com.example.springmongographql.model.Publisher;
import com.example.springmongographql.model.Tag;
import com.example.springmongographql.repository.AuthorRepository;
import com.example.springmongographql.repository.BookRepository;
import com.example.springmongographql.repository.PublisherRepository;
import com.example.springmongographql.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(String id) {
        return tagRepository.findById(id);
    }

    public List<Tag> getMultipleTags(List<String> tagIds) {
        return tagRepository.findAllByIdIn(tagIds);
    }

    public List<Book> getAllBooksWithTag(String tagId) {
        return bookRepository.findAllByTagIdsContaining(tagId);
    }

    public List<Publisher> getAllPublishersWithTag(String tagId) {
        return publisherRepository.findAllByTagIdsContaining(tagId);
    }

    public List<Author> getAllAuthorsWithTag(String tagId) {
        return authorRepository.findAllByTagIdsContaining(tagId);
    }
}
