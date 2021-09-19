package com.example.hibernate_01.Repositories;

import com.example.hibernate_01.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    @Query("select b from Book b where b.title = :title")
    Optional<Book> findByTitle(String title);
}
