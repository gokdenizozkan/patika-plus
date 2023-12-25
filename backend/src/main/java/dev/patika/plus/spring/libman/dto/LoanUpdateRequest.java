package dev.patika.plus.spring.libman.dto;

import dev.patika.plus.spring.libman.entity.Book;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LoanUpdateRequest(
        @NotNull long id,
        String borrowerName,
        LocalDate borrowingDate,
        LocalDate returnDate,
        Book book
) {
}
