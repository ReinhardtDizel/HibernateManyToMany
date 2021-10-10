package com.example.hibernate_01.Services.Interfaces;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    void delete(String id);
    boolean existsById(String id);
    Optional<Book> getByTitle(String title);
    Optional<Book> getById(String id);

    ResponseEntity<Book> editBookAuthors(String id, Author author);

    List<Book> getAll();
    void deleteById(String id);
}
