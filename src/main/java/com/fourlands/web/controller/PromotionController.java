package com.fourlandsmarket.web.controller;

import com.fourlandsmarket.domain.dto.Promotion;
import com.fourlandsmarket.domain.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    @Autowired
    PromotionService promotionService;

    @GetMapping("/getall")
    public ResponseEntity<List<Promotion>> getAll() {

        return new ResponseEntity<>(promotionService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/getPromotionByNameCategory/{name}")
    public ResponseEntity<List<Promotion>> getProduct(@PathVariable String name) {

        return promotionService.getPromotionByNameCategory(name).
                map(promtion -> new ResponseEntity<>(promtion, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
