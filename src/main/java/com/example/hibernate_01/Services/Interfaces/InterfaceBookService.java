package com.example.hibernate_01.Services.Interfaces;

import com.example.hibernate_01.Model.Book;

import java.util.List;
import java.util.Optional;

public interface InterfaceBookService {
    Book save(Book book);
    void delete(String id);
    Optional<Book> getByTitle(String title);
    Optional<Book> getById(String id);
    Book editBook(Book book);
    List<Book> getAll();
}
