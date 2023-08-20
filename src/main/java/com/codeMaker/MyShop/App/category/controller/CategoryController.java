package com.codeMaker.MyShop.App.category.controller;


import com.codeMaker.MyShop.App.category.model.Category;
import com.codeMaker.MyShop.App.category.model.CategoryRequest;
import com.codeMaker.MyShop.App.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    // Tutaj możesz dodać dodatkowe endpointy, jeśli są potrzebne.
}
