package com.maar.bookstore.books;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private byte[] image; // Store image as binary data
    private String description;
    private String publishedDate;
    private List<String> reviews;

    public Book(String id, String name, String author, byte[] image, String description, String publishedDate, List<String> reviews) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
        this.description = description;
        this.publishedDate = publishedDate;
        this.reviews = reviews;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public byte[] getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<String> getReviews() {
        return reviews;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    // equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(image, book.image) &&
                Objects.equals(description, book.description) &&
                Objects.equals(publishedDate, book.publishedDate) &&
                Objects.equals(reviews, book.reviews);
    }

    // hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, image, description, publishedDate, reviews);
    }

    // toString() method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image=" + (image != null ? "data present" : "no data") +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
