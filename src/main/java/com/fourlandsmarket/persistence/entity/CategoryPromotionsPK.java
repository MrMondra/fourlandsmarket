package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CategoryPromotionsPK implements Serializable {
    @Column(name = "id_promotion")
    private Integer idPromotion;
    @Column(name = "id_category")
    private Integer idCategory;
}
