package com.fourlandsmarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuck")
public class FuckController {
    @GetMapping("/yeah")
    public String hpYeah() {
        return "SI SE PODIA BENDITO DIOS";
    }
}
