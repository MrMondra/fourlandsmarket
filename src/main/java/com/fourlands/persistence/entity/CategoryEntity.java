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

    //good
    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntities;

    //good
    @OneToMany(mappedBy = "categoryEntity")
    private List<CategoryPromotionEntity> categoryPromotionEntities;


    private String name;
    private String description;
    private String image_url;
}
