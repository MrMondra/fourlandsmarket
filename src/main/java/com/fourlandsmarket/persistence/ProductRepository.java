package com.fourlandsmarket.persistence;

import com.fourlandsmarket.persistence.crud.ProductCrudRepository;
import com.fourlandsmarket.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarceProducts() {
        return productCrudRepository.findByStockLessThan();
    }

    public Optional<Product> getProduct(Integer idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(Integer idProducto) {
        productCrudRepository.deleteById(idProducto);
    }
}
