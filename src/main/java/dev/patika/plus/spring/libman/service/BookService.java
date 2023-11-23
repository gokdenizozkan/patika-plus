package dev.patika.plus.spring.libman.service;

import dev.patika.plus.spring.libman.dto.BookResponse;
import dev.patika.plus.spring.libman.mapper.BookResponseMapper;
import dev.patika.plus.spring.libman.repository.BookRepository;
import dev.patika.plus.spring.libman.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookResponseMapper bookResponseMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookResponseMapper bookResponseMapper) {
        this.bookRepository = bookRepository;
        this.bookResponseMapper = bookResponseMapper;
    }

    public List<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookResponseMapper)
                .collect(Collectors.toList());
    }
}
