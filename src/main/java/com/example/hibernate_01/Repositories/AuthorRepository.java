package com.example.hibernate_01.Repositories;


import com.example.hibernate_01.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
    boolean existsById(String s);
}
