package com.fourlandsmarket.domain.repository;

import com.fourlandsmarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(Integer idCategoria);

    Optional<List<Product>> getScarseProducts(Integer quantity);

    Optional<Product> getProduct(Integer idProduct);

    Product save(Product product);

    void delete(Integer idProduct);
}
