package com.example.hibernate_01.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "title", length = 300, nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    @Type(type="text")
    private String description;

    @Column(name = "publishing_date", nullable = false)
    @Type(type="timestamp")
    private Timestamp publishing;

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("book")
    private Set<Image> images = new HashSet<>();

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnoreProperties("books") // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    private Set<Author> authors = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPublishing() {
        return publishing;
    }

    public void setPublishing(Timestamp publishing) {
        this.publishing = publishing;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishing=" + publishing +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", images=" + images +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId().equals(book.getId()) && getTitle().equals(book.getTitle()) && getDescription().equals(book.getDescription()) && getPublishing().equals(book.getPublishing()) && Objects.equals(createdAt, book.createdAt) && Objects.equals(updatedAt, book.updatedAt) && getImages().equals(book.getImages()) && getAuthors().equals(book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getPublishing(), createdAt, updatedAt, getImages(), getAuthors());
    }
}
