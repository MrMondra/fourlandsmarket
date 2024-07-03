package com.fourlands.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductPromotionPK implements Serializable {

    @Column(name = "id_promotion")
    private Integer idPromotion;

    @Column(name = "id_product")
    private Integer idProduct;

}
