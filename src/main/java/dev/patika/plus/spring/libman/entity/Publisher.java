package dev.patika.plus.spring.libman.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "publisher")
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @Column(name = "establishment_year")
    private int establishmentYear;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
