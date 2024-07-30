package com.maar.bookstore.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/book")
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

    @GetMapping("/{id}")
    public Book findbook(@PathVariable("id") String idString)
    {
        Long id = Long.parseLong(idString);
        return br.findById(id).orElse(null);
    }
}
