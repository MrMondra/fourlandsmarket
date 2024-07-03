package com.fourlands.persistence.crud;

import com.fourlands.persistence.entity.PromotionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionCrudRepository extends CrudRepository<PromotionEntity, Integer> {

    List<PromotionEntity> findByProductPromotionEntitiesProductEntityCategoryEntityName(String name);

}
