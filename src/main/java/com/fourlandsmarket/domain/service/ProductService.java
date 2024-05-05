package com.fourlandsmarket.domain.service;

import com.fourlandsmarket.domain.Product;
import com.fourlandsmarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(Integer idCategoria) {
        return productRepository.getByCategory(idCategoria);
    }

    public Optional<Product> getProduct(Integer idProduct) {
        return productRepository.getProduct(idProduct);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    //Analizar codigo
    public boolean delete(Integer idProduct) {
        /*return getProduct(idProduct).map(product -> {
            return true;
        }).orElse(false);*/
        if (getProduct(idProduct).isPresent()) {
            productRepository.delete(idProduct);
            return true;
        } else {
            return false;
        }
    }


}
