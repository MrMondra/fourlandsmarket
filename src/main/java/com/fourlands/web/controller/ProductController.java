package com.fourlands.web.controller;

import com.fourlands.common.infrastructure.TenantContext;
import com.fourlands.domain.dto.Product;
import com.fourlands.domain.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@Transactional
@RequestMapping("/products")
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService productService;


    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAll() {

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer idProduct) {

        return productService.getProduct(idProduct).
                map(product -> new ResponseEntity<>(product, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{idCategoria}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable Integer idCategoria) {
        String currentTenant = TenantContext.getCurrentTenant();
        LOGGER.info("Handling request for tenant: " + currentTenant);
        return productService.getByCategory(idCategoria).
                map(products -> new ResponseEntity<>(products, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer idProduct) {
        if (productService.delete(idProduct)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
