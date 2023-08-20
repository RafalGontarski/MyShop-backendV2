package com.codeMaker.MyShop.App.category.service;

import com.codeMaker.MyShop.App.category.model.Category;
import com.codeMaker.MyShop.App.category.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category addCategory(Category category) {
        // Możesz dodać dodatkową logikę walidacji lub przetwarzania przed zapisaniem kategorii
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    // Tutaj możesz dodać dodatkowe metody serwisu, jeśli są potrzebne.
}
