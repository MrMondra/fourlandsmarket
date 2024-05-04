package com.fourlandsmarket.web.controller;

import com.fourlandsmarket.domain.Product;
import com.fourlandsmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Integer idProduct) {
        return productService.getProduct(idProduct);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(Integer idCategoria) {
        return productService.getByCategory(idCategoria);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer idProduct) {
        return productService.delete(idProduct);
    }
}
