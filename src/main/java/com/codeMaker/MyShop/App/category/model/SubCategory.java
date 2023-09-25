package com.codeMaker.MyShop.App.category.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sub_categories")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String iconUrl;

    // Jeśli subkategoria jest powiązana z kategorią główną
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
}
