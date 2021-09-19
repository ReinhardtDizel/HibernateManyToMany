package com.example.hibernate_01.Services.Interfaces;

import com.example.hibernate_01.Model.Author;

import java.util.List;
import java.util.Optional;

public interface InterfaceAuthorService {
    Author save(Author author);
    void delete(String id);
    Author getByName(String name);
    Optional<Author> getById(String id);
    Author editAuthor(Author author);
    List<Author> getAll();
}
