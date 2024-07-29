package com.maar.bookstore.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class BookController {
//    private final BookService bookService;


    @Autowired
    private  BookRepository br;
   // public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book)
    {
        return br.save(book);
    }

    @GetMapping("/")
    public List<Book> getBooks(){
        return br.findAll();
    }
//    return br.findAll();
}
