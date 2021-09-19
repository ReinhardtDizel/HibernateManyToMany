package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Repositories.BookRepository;
import com.example.hibernate_01.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {//Написать Сервис
        this.bookRepository = bookRepository;//MVC
    }

    @PostMapping()
    void postBook(@RequestBody Book book) {
         bookRepository.save(book);//Написать Сервис
    }

    @GetMapping()
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        return bookRepository.findById(id);
    }
}
