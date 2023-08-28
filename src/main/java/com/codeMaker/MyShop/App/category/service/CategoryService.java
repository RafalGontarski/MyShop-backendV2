package com.codeMaker.MyShop.App.category.service;

import com.codeMaker.MyShop.App.category.model.Category;
import com.codeMaker.MyShop.App.category.model.CategoryRepository;
import com.codeMaker.MyShop.App.category.model.SubCategory;
import com.codeMaker.MyShop.App.category.model.SubCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Transactional
    public Category addCategory(Category category) {
        // Możesz dodać dodatkową logikę walidacji lub przetwarzania przed zapisaniem kategorii
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<String> getSubCategoryNamesByCategoryId(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new EntityNotFoundException("Category with id " + categoryId + " not found");
        }

        List<SubCategory> subCategories = subCategoryRepository.findByCategoryCategoryId(categoryId);
        return subCategories.stream()
                .map(SubCategory::getName)
                .collect(Collectors.toList());
    }





    // Tutaj możesz dodać dodatkowe metody serwisu, jeśli są potrzebne.
}
