package com.codeMaker.MyShop.App.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySubCategoryId(Long subCategoryId);
    List<Product> findBySecondSubCategoryId(Long secondSubCategoryId);
}

