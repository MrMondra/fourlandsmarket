package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "")
@Getter
@Setter
public class ProductPromotion {
    @EmbeddedId
    private ProductPromotionPK id;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @MapsId("idPromotion")
    @JoinColumn(name = "id_promotion", insertable = false, updatable = false)
    private Promotion promotion;
}
