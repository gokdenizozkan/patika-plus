package dev.patika.plus.spring.libman.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.plus.spring.libman.entity.Author;
import dev.patika.plus.spring.libman.entity.Category;
import dev.patika.plus.spring.libman.entity.Publisher;
import jakarta.persistence.*;

import java.util.List;

public record BookResponse(
        long id,
        String name,
        int publicationYear,
        int stock,
        AuthorDto author,
        PublisherDto publisher,
        List<CategoryDto> categories
){}
