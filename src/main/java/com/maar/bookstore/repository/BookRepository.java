package com.maar.bookstore.repository;

import com.maar.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    // Additional query methods can be defined here if needed
}
