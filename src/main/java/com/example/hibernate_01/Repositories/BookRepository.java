package com.example.hibernate_01.Repositories;

import com.example.hibernate_01.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsById(String s);
    Optional<Book> findByTitle(String title);
    void deleteById(String id);
}
