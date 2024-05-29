package com.fourlands.persistence.crud;

import com.fourlands.persistence.entity.ProductEntity;
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
