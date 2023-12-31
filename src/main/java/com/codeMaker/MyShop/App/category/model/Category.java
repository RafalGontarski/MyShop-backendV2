package com.codeMaker.MyShop.App.category.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
//    private String description;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    private List<SubCategory> subCategories;

    private String imageUrl;
    private String iconUrl;
//    private String slug;
//    private Integer displayOrder;

//    private Boolean isActive;

//    @OneToMany(mappedBy = "category")
//    private List<Product> products;

//    private String metadata;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
