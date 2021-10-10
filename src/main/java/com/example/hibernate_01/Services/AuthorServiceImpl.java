package com.example.hibernate_01.Services;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
import com.example.hibernate_01.Repositories.AuthorRepository;
import com.example.hibernate_01.Services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author save(Author author) {
        Author savedBook = authorRepository.save(author);
        return savedBook;
    }
    @Override
    public void delete(String id) {

    }
    @Override
    public Author getByName(String name) {
        return null;
    }
    @Override
    public boolean existsById(String id) {
        return authorRepository.existsById(id);
    }
    @Override
    public Optional<Author> getById(String id) {
        return authorRepository.findById(id);
    }
    @Override
    public Author editAuthor(Author author) {
        return authorRepository.save(author);
    }
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
