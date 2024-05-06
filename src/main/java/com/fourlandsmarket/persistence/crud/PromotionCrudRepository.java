package com.fourlandsmarket.persistence.crud;

import com.fourlandsmarket.persistence.entity.PromotionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionCrudRepository extends CrudRepository<PromotionEntity, Integer> {

    List<PromotionEntity> findByProductPromotionEntitiesProductEntityCategoryEntityName(String name);

}
