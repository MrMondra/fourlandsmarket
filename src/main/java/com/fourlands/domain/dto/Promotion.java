package com.fourlandsmarket.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Promotion {
    private Integer idPromotion;
    private String description;
    private Double discount;
    private List<Product> products;
    private List<Category> categories;
}
