package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category_promotions")
@Getter
@Setter
public class CategoryPromotion {
    @EmbeddedId
    private CategoryPromotionsPK id;

    @ManyToOne
    @MapsId("idCategory")
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @MapsId("idPromotion")
    @JoinColumn(name = "id_promotion", insertable = false, updatable = false)
    private Promotion promotion;

}
