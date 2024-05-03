package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private OrderDetail orderDetail;
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Review review;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<ProductPromotion> productPromotions;

    private String name;
    private String description;
    private Double price;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer stock;


}
