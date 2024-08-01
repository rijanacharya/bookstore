package com.maar.bookstore.books;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public Book addBook(@RequestParam("image") MultipartFile image,
                        @RequestParam("name") String name,
                        @RequestParam("author") String author,
                        @RequestParam("description") String description,
                        @RequestParam("publishedDate") String publishedDate,
                        @RequestParam("reviews") String reviews) {

        byte[] imageData = null;
        try {
            imageData = image.getBytes(); // Convert image to byte array
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the error appropriately in a real application
        }

        Book book = new Book(null, name, author, imageData, description, publishedDate, List.of(reviews.split(",")));
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}/image")
    public ResponseEntity<byte[]> getBookImage(@PathVariable String id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Book book = bookOptional.get();
        byte[] imageData = book.getImage();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Adjust content type as needed
                .body(imageData);
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
//    return br.findAll();
}
