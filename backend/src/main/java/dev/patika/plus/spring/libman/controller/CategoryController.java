package dev.patika.plus.spring.libman.controller;

import dev.patika.plus.spring.libman.entity.Category;
import dev.patika.plus.spring.libman.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/delete-category/{id}")
    String deleteCategory(@PathVariable long id) {
        boolean successful = categoryService.deleteById(id);

        if (successful) return "Category deleted";
        else return "Category could not be deleted because it has books associated with it.";
    }

    @GetMapping
    List<Category> getCategories() {
        return categoryService.getAll();
    }
}
