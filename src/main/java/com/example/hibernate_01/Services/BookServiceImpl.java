package com.example.hibernate_01.Services;


import com.example.hibernate_01.Model.Book;
import com.example.hibernate_01.Repositories.BookRepository;
import com.example.hibernate_01.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    @Override
    public void delete(String id) {

    }
    @Override
    public Optional<Book> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    @Override
    public Optional<Book> getById(String id) {
        return bookRepository.findById(id);
    }
    @Override
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
