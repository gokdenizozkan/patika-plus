package dev.patika.plus.spring.week11.libman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    private String name;
    private int establishmentYear;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
