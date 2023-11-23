package dev.patika.plus.spring.libman.dto;

import java.time.LocalDate;

public record AuthorDto(
        long id,
        String name,
        LocalDate birthDate,
        String country
) {
}
