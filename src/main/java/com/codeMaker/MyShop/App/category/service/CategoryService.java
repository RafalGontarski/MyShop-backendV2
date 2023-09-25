package com.codeMaker.MyShop.App.category.service;

import com.codeMaker.MyShop.App.category.model.*;
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
    private final SecondSubCategoryRepository secondSubCategoryRepository;


    @Autowired
    public CategoryService(
            CategoryRepository categoryRepository,
            SubCategoryRepository subCategoryRepository,
            SecondSubCategoryRepository secondSubCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.secondSubCategoryRepository = secondSubCategoryRepository;
    }

    @Transactional
    public Category addCategory(Category category) {
        // Możesz dodać dodatkową logikę walidacji lub przetwarzania przed zapisaniem kategorii
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<SubCategory> getAllSubCategoriesByCategoryId(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new EntityNotFoundException("Category with id " + categoryId + " not found");
        }

        return subCategoryRepository.findByCategoryCategoryId(categoryId);
    }

    public List<SecondSubCategory> getAllSecondSubCategoriesByCategoryId(Long subCategoryId) {
        if (!subCategoryRepository.existsById(subCategoryId)) {
            throw new EntityNotFoundException("Category with id " + subCategoryId + " not found");
        }

        return secondSubCategoryRepository.findSecondSubCategoryBySubCategoryId(subCategoryId);
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

    public Long getSubCategoryIdByName(String name) {
        SubCategory subCategory = subCategoryRepository.findByName(name);
        if (subCategory != null) {
            return subCategory.getId();
        } else {
            throw new EntityNotFoundException("SubCategory not found with name: " + name);
        }
    }






    // Tutaj możesz dodać dodatkowe metody serwisu, jeśli są potrzebne.
}
