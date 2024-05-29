package com.fourlands.domain.service;

import com.fourlands.domain.dto.Product;
import com.fourlands.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<List<Product>> getByCategory(Integer idCategoria) {
        return productRepository.getByCategory(idCategoria);
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProduct(Integer idProduct) {
        return productRepository.getProduct(idProduct);
    }

    @Transactional()
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
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
