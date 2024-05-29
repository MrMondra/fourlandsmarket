package com.fourlands.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @ManyToOne
    @JoinColumn(name = "id_category", updatable = false)
    private CategoryEntity categoryEntity;

    //good
    @OneToMany(mappedBy = "productEntity")
    List<OrderDetailEntity> orderDetailEntities;

    //good
    @OneToMany(mappedBy = "productEntity")
    private List<ReviewEntity> reviewEntities;

    //good
    @OneToMany(mappedBy = "productEntity")
    private List<ProductPromotionEntity> productPromotionEntities;

    private String name;
    private String description;
    private Double price;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer stock;


}
