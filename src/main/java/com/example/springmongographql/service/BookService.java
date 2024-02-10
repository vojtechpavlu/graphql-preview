package com.example.springmongographql.service;

import com.example.springmongographql.model.Book;
import com.example.springmongographql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksOfPublisher(String publisherId) {
        return bookRepository.findBooksByPublisherId(publisherId);
    }

    public List<Book> getBooksOfAuthor(String authorId) {
        return bookRepository.findAllByAuthorIdsContaining(authorId);
    }
}
