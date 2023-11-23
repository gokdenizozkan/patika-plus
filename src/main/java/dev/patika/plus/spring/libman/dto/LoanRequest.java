package dev.patika.plus.spring.libman.dto;

import dev.patika.plus.spring.libman.entity.Book;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LoanRequest (
        String borrowerName,
        @Email String borrowerEmail,
        LocalDate borrowingDate,
        LocalDate returnDate,
        @NotNull Book book
)
{}
