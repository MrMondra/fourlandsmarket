package com.fourlands.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_promotions")
@Getter
@Setter
public class ProductPromotionEntity {
    @EmbeddedId
    private ProductPromotionPK id;

    //good
    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ProductEntity productEntity;

    //good
    @ManyToOne
    @MapsId("idPromotion")
    @JoinColumn(name = "id_promotion", insertable = false, updatable = false)
    private PromotionEntity promotionEntity;
}
