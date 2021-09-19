package com.example.hibernate_01.Repositories;

import com.example.hibernate_01.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
