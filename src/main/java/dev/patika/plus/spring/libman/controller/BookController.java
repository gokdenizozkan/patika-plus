package dev.patika.plus.spring.libman.controller;

import dev.patika.plus.spring.libman.dto.BookResponse;
import dev.patika.plus.spring.libman.service.BookService;
import dev.patika.plus.spring.libman.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getAll() {
        return bookService.getAll();
    }
}
