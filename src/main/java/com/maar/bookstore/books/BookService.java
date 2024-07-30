package com.maar.bookstore.books;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    public List<Book> getStudents() {
        return List.of(
                new Book(1L,"Rich dad poor dad","arthur nery")
        );
    }
}
