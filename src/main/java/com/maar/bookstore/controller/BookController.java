package com.maar.bookstore.controller;

import com.maar.bookstore.model.Book;
import com.maar.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestPart("book") Book book,
                                           @RequestPart("image") MultipartFile image) throws IOException {
        book.setImage(bookService.storeImage(image));
        Book savedBook = bookService.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id,
                                           @Valid @RequestPart("book") Book book,
                                           @RequestPart("image") MultipartFile image) throws IOException {
        if (bookService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        book.setImage(bookService.storeImage(image));
        Book updatedBook = bookService.update(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        if (bookService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
