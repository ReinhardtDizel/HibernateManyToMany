package com.example.hibernate_01.Repositories;


import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, String> {
    boolean existsById(String s);
}
