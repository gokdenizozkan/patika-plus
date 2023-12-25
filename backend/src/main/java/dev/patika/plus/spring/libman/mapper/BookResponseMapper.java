package dev.patika.plus.spring.libman.mapper;

import dev.patika.plus.spring.libman.dto.AuthorDto;
import dev.patika.plus.spring.libman.dto.BookResponse;
import dev.patika.plus.spring.libman.dto.CategoryDto;
import dev.patika.plus.spring.libman.dto.PublisherDto;
import dev.patika.plus.spring.libman.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookResponseMapper implements Function<Book, BookResponse> {

        @Override
        public BookResponse apply(Book book) {
            return new BookResponse(
                    book.getId(),
                    book.getName(),
                    book.getPublicationYear(),
                    book.getStock(),
                    new AuthorDto(
                            book.getAuthor().getId(),
                            book.getAuthor().getName(),
                            book.getAuthor().getBirthDate(),
                            book.getAuthor().getCountry()
                    ),
                    new PublisherDto(
                            book.getPublisher().getId(),
                            book.getPublisher().getName(),
                            book.getPublisher().getEstablishmentYear(),
                            book.getPublisher().getAddress()
                    ),
                    book.getCategories().stream()
                            .map(category -> new CategoryDto(
                                    category.getId(),
                                    category.getName()
                            ))
                            .collect(Collectors.toList())
            );
        }

}
