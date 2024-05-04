package com.fourlandsmarket.persistence;

import com.fourlandsmarket.persistence.crud.ProductCrudRepository;
import com.fourlandsmarket.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<ProductEntity> getAll() {
        return (List<ProductEntity>) productCrudRepository.findAll();
    }

    public List<ProductEntity> getByCategory(int idCategory) {
        return productCrudRepository.findByCategoryIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<ProductEntity>> getScarceProducts(Integer cantidad) {
        return productCrudRepository.findByStockLessThan(cantidad);
    }

    public Optional<ProductEntity> getProduct(Integer idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public ProductEntity save(ProductEntity product) {
        return productCrudRepository.save(product);
    }

    public void delete(Integer idProducto) {
        productCrudRepository.deleteById(idProducto);
    }
}
