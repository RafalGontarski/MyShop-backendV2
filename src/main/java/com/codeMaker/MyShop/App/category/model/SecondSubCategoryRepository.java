package com.codeMaker.MyShop.App.category.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondSubCategoryRepository extends JpaRepository<SecondSubCategory, Long> {
    List<SecondSubCategory> findSecondSubCategoryBySubCategoryId(Long subCategoryId);

    SecondSubCategory findByName(String name);

    // Tutaj możesz dodawać dodatkowe metody, jeśli są potrzebne.
}

