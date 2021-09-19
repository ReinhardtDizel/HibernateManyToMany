package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @PostMapping
    Author postAuthor(@RequestBody Author author) {
        return authorServiceImpl.save(author);
    }
    @GetMapping
    List<Author> getAuthor() {
        return authorServiceImpl.getAll();
    }

}
