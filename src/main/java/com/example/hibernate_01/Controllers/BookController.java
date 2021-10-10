package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Author;
import com.example.hibernate_01.Model.Book;
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
        if(!bookServiceImpl.existsById(id)) {
            return new ResponseEntity<>(bookServiceImpl.save(book), HttpStatus.CREATED);
        }
        else if(bookServiceImpl.existsById(id)) {

            Book existingBook = bookServiceImpl.getById(id).get();
            existingBook.setTitle(book.getTitle());
            existingBook.setDescription(book.getDescription());
            existingBook.setPublishing(book.getPublishing());

            Set<Author> existAuthors = existingBook.getAuthors();
            Set<Author> newAuthors = book.getAuthors();
            Iterator<Author> iterExist = existAuthors.iterator();
            Iterator<Author> iterNew = newAuthors.iterator();
            Author existAuthor = new Author();
            Author newAuthor  = new Author();

            if(existAuthors.size() == newAuthors.size()) {
                while (iterExist.hasNext()) {
                    existAuthor = (Author)iterExist.next();
                    newAuthor.setBio(existAuthor.getBio());
                    newAuthor.setName(existAuthor.getName());
                    newAuthor.setBooks(existAuthor.getBooks());
                    return bookServiceImpl.editBookAuthors(id,newAuthor);
                }
            }
            else if(existAuthors.size() != newAuthors.size()) {
                while (iterExist.hasNext()) {
                    existAuthor = (Author)iterExist.next();
                    newAuthor  = (Author)iterNew.next();
                    existAuthor.setBio(newAuthor.getBio());
                    existAuthor.setName(newAuthor.getName());
                }
            }

            return null;


            /*existingBook.setTitle(book.getTitle());
            existingBook.setDescription(book.getDescription());
            existingBook.setImage(book.getImage());
            existingBook.setPublishing(book.getPublishing());
            return new ResponseEntity<>(bookServiceImpl.save(existingBook), HttpStatus.OK);
             */

        }
        else return null;
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
