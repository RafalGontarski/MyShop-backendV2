package com.codeMaker.MyShop.App.category.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategoryCategoryId(Long categoryId);

    SubCategory findByName(String name);

    // Tutaj możesz dodawać dodatkowe metody, jeśli są potrzebne.
}

