package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    @OneToMany(mappedBy = "category")
    private List<CategoryPromotionEntity> categoryPromotions;


    private String name;
    private String description;
    private String image_url;
}
