package dev.patika.plus.spring.libman.repository;

import dev.patika.plus.spring.libman.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
