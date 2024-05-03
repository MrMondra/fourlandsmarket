package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "promotions")
@Getter
@Setter
public class PromotionEntity {
    @Id
    @Column(name = "id_promotion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromotion;
    @OneToMany(mappedBy = "promotion")
    private List<CategoryPromotionEntity> categoryPromotions;

    @OneToMany(mappedBy = "promotion")
    private List<ProductPromotionEntity> productPromotions;

    private String description;
    private Double discount;
    @Column(name = "start_date")
    private LocalDateTime dateStart;
    @Column(name = "end_date")
    private LocalDateTime dateEnd;
}
