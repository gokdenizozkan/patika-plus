package dev.patika.plus.spring.libman.service;

import dev.patika.plus.spring.libman.entity.Category;
import dev.patika.plus.spring.libman.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * To delete a category, category needs to have no books associated with it.
     * @param id of the category
     * @return true if the category is deleted, false otherwise
     */
    public boolean deleteById(Long id) {
        Category category = categoryRepository.findById(id).get();
        if (category.getBooks().isEmpty()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
