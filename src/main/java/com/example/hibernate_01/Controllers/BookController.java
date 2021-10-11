package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
import com.example.hibernate_01.Model.Interfaces.NameImpl;
import com.example.hibernate_01.Services.AuthorServiceImpl;
import com.example.hibernate_01.Services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;
    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @PostMapping
    Book postBook(@RequestBody Book book) {
        return bookServiceImpl.save(book);
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> putBook(@PathVariable String id, @RequestBody Book book) {
        return bookServiceImpl.editBook(id, book);
    }

    @GetMapping
    List<Book> getBooks() {
        return bookServiceImpl.getAll();
    }
    @GetMapping("/title/{title}")
    Optional<Book> getBookByTitle(@PathVariable String title) {
        return bookServiceImpl.getByTitle(title);
    }
    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        return bookServiceImpl.getById(id);
    }
    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id) {
        bookServiceImpl.deleteById(id);
    }
}
