package com.fourlandsmarket.persistence.crud;

import com.fourlandsmarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    //Get products by Id Category
    List<Product> findByCategoryIdOrderByNameAsc(Integer idCategory);

    Optional<List<Product>> findByStockLessThan();

}
