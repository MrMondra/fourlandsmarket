package com.fourlandsmarket.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer idProduct;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Category category;
}
