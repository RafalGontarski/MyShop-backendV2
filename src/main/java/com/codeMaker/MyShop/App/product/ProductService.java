package com.codeMaker.MyShop.App.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        if (product.getSubCategory() != null && product.getSecondSubCategory() != null) {
            throw new IllegalArgumentException("Produkt może być przypisany albo do SubCategory albo do SecondSubCategory, ale nie do obu jednocześnie!");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> getProductsBySubCategoryId(Long subCategoryId) {
        return productRepository.findBySubCategoryId(subCategoryId);
    }

    public List<Product> getProductsBySecondSubCategoryId(Long secondSubCategoryId) {
        return productRepository.findBySecondSubCategoryId(secondSubCategoryId);
    }
}

