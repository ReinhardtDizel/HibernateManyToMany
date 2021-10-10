package com.example.hibernate_01.Services;


import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
import com.example.hibernate_01.Repositories.BookRepository;
import com.example.hibernate_01.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public boolean existsById(String id) {
        return bookRepository.existsById(id);
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
    public ResponseEntity<Book> editBookAuthors(String id, Author author) {
        if(this.existsById(id)){
            Book existBook = this.getById(id).get();
            existBook.getAuthors().add(author);

            return new ResponseEntity<>(this.save(existBook), HttpStatus.OK);
        }
        else return null;
    }
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}
