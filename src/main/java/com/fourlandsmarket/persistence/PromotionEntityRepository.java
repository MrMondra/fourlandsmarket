package com.fourlandsmarket.persistence;

import com.fourlandsmarket.domain.dto.Promotion;
import com.fourlandsmarket.domain.repository.PromotionRepository;
import com.fourlandsmarket.persistence.Mapper.PromotionMapper;
import com.fourlandsmarket.persistence.crud.PromotionCrudRepository;
import com.fourlandsmarket.persistence.entity.PromotionEntity;
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
