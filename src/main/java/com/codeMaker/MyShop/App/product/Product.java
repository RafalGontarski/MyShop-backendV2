package com.codeMaker.MyShop.App.product;

import com.codeMaker.MyShop.App.category.model.SecondSubCategory;
import com.codeMaker.MyShop.App.category.model.SubCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "second_sub_category_id", nullable = false)
    private SecondSubCategory secondSubCategory;

    // Gettery, settery, konstruktory, equals, hashCode, toString...
}

