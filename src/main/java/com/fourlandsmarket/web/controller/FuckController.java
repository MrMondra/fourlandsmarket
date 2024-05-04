package com.fourlandsmarket.web.controller;

import com.fourlandsmarket.persistence.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuck")
public class FuckController {
    @GetMapping("/yeah")
    public String hpYeah() {
        ProductRepository productRepository = new ProductRepository();
        return productRepository.getAll().toString();
    }
}
