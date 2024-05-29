package com.fourlands.persistence;

import com.fourlands.domain.dto.Promotion;
import com.fourlands.domain.repository.PromotionRepository;
import com.fourlands.persistence.crud.PromotionCrudRepository;
import com.fourlands.persistence.entity.PromotionEntity;
import com.fourlands.persistence.mapper.PromotionMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@Setter
public class PromotionEntityRepository implements PromotionRepository {

    @Autowired
    private PromotionCrudRepository promotionCrudRepository;
    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public List<Promotion> getAll() {
        List<PromotionEntity> promotionEntities = (List<PromotionEntity>) promotionCrudRepository.findAll();
        return promotionMapper.toPromotions(promotionEntities);
    }

    @Override
    public Optional<List<Promotion>> getPromotionByNameCategory(String nameCategory) {
        List<PromotionEntity> promotions = promotionCrudRepository.findByProductPromotionEntitiesProductEntityCategoryEntityName(nameCategory);
        return Optional.of(promotionMapper.toPromotions(promotions));
    }
}
