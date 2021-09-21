package com.example.hibernate_01.Model;

import com.example.hibernate_01.Model.Interfaces.NameImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Columns(columns = { @Column(name = "full_name"),
                         @Column(name = "first_name"),
                         @Column(name = "middle_name"),
                         @Column(name = "last_name"),
                         @Column(name = "short_name")
    })
    @Type(type = "com.example.hibernate_01.Types.NameTypeDescriptor")
    private NameImpl name;

    @Column(name = "bio", nullable = true)
    @Type(type="text")
    private String bio;

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors") // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    private Set<Book> books = new HashSet<>();

    public NameImpl getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new NameImpl(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
