package com.fourlands.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @Column(name = "id_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReview;

    //good
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ProductEntity productEntity;

    //good
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserEntity userEntity;

    private Integer rating;

    private String comment;

    private LocalDateTime date;

}
