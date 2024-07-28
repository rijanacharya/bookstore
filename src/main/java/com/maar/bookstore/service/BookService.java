package com.maar.bookstore.service;

import com.maar.bookstore.exception.BookNotFoundException;
import com.maar.bookstore.model.Book;
import com.maar.bookstore.model.Image;
import com.maar.bookstore.repository.BookRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(String id, Book book) {
        Book existingBook = findById(id);
        book.setId(existingBook.getId());
        return bookRepository.save(book);
    }

    public void delete(String id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }

    public Image storeImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setData(new Binary(file.getBytes()));
        image.setContentType(file.getContentType());
        return image;
    }
}
