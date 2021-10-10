package com.example.hibernate_01.Services.Interfaces;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorService {
    Author save(Author author);
    boolean existsById(String id);
    void delete(String id);
    Author getByName(String name);
    Optional<Author> getById(String id);
    Author editAuthor(Author author);
    List<Author> getAll();
}
