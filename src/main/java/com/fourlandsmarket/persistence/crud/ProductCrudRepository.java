package com.fourlandsmarket.persistence.crud;

import com.fourlandsmarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Easy CRUD Repository with QueryMethods
@Repository
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    //Get products by Id Category
    List<ProductEntity> findByCategoryEntityIdCategoryOrderByNameAsc(Integer idCategory);

    Optional<List<ProductEntity>> findByStockLessThan(Integer cantidad);

}
