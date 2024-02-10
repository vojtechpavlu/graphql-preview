package com.example.springmongographql.service;

import com.example.springmongographql.model.Author;
import com.example.springmongographql.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }

    public List<Author> getMultipleAuthors(List<String> authorIds) {
        return authorRepository.findAllByIdIn(authorIds);
    }
}
