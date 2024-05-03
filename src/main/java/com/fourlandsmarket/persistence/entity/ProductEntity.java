package com.fourlandsmarket.persistence.entity;

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
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private OrderDetailEntity orderDetail;
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ReviewEntity review;

    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "product")
    private List<ProductPromotionEntity> productPromotions;

    private String name;
    private String description;
    private Double price;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer stock;


}
