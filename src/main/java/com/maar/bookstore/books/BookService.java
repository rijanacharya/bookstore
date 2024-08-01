package com.maar.bookstore.books;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    public List<Book> getStudents() {
        return List.of(
                new Book("12",
                        "Rich Dad Poor Dad",
                        "Robert Kiyosaki",
                        null,
                        "A book about financial literacy",
                        "2000",
                        List.of("Great book!", "Very informative"))
        );
    }
}
