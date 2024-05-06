package com.fourlandsmarket.persistence;

import com.fourlandsmarket.domain.dto.Product;
import com.fourlandsmarket.domain.repository.ProductRepository;
import com.fourlandsmarket.persistence.Mapper.ProductMapper;
import com.fourlandsmarket.persistence.crud.ProductCrudRepository;
import com.fourlandsmarket.persistence.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@Setter
public class ProductEntityRepository implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(productEntities);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer idCategoria) {
        List<ProductEntity> productEntities = productCrudRepository.findByCategoryEntityIdCategoryOrderByNameAsc(idCategoria);
        return Optional.of(productMapper.toProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        Optional<List<ProductEntity>> productEntities = productCrudRepository.findByStockLessThan(quantity);
        return productEntities.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Integer idProduct) {
        return productCrudRepository.findById(idProduct).map(prod -> productMapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(Integer idProducto) {
        productCrudRepository.deleteById(idProducto);
    }
}
