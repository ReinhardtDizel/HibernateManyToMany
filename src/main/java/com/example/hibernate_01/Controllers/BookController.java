package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Book;
import com.example.hibernate_01.Services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @PostMapping
    Book postBook(@RequestBody Book book) {
        return bookServiceImpl.save(book);
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
}
