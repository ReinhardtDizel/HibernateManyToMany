package com.example.hibernate_01.Model;

import com.example.hibernate_01.Model.Interfaces.NameImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(name = "first_name", length = 255, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    @Column(name = "middle_name", length = 255, nullable = false)
    private String middleName;

    @Column(name = "short_name", length = 255, nullable = false)
    private String shortName;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "bio", nullable = true)
    @Type(type="text")
    private String bio;

    @Column(name = "CREATED_AT", nullable = false)
    @Type(type="timestamp")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    @Type(type="timestamp")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors") // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    private Set<Book> books = new HashSet<>();

    @PrePersist
    public void createNames() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
