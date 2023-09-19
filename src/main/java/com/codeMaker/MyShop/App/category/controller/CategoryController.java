package com.codeMaker.MyShop.App.category.controller;


import com.codeMaker.MyShop.App.category.model.Category;
import com.codeMaker.MyShop.App.category.model.CategoryRequest;
import com.codeMaker.MyShop.App.category.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
//        category.setIconUrl(categoryRequest.getIconUrl());
        // Data powstania zostanie automatycznie ustawiona dzięki adnotacji @CreationTimestamp w modelu Category

        Category savedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        log.info("Fetched categories: {}", categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{categoryId}/subcategories/names")
    public ResponseEntity<List<String>> getSubCategoryNames(@PathVariable Long categoryId) {
        try {
            List<String> subCategoryNames = categoryService.getSubCategoryNamesByCategoryId(categoryId);
            return new ResponseEntity<>(subCategoryNames, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subcategories/id")
    public ResponseEntity<Long> getSubCategoryIdByName(@RequestParam String name) {
        try {
            Long subCategoryId = categoryService.getSubCategoryIdByName(name);
            return new ResponseEntity<>(subCategoryId, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // Tutaj możesz dodać dodatkowe endpointy, jeśli są potrzebne.
}
