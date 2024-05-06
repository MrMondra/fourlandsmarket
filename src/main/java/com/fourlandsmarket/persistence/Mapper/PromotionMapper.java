package com.fourlandsmarket.persistence.Mapper;


import com.fourlandsmarket.domain.dto.Promotion;
import com.fourlandsmarket.persistence.entity.PromotionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductPromotionMapper.class, CategoryPromotionMapper.class})
public interface PromotionMapper {

    @Mappings({
            @Mapping(source = "idPromotion", target = "idPromotion"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "productPromotionEntities", target = "products"),
            @Mapping(source = "categoryPromotionEntities", target = "categories")
    })
    Promotion toPromotion(PromotionEntity promotionEntity);

    List<Promotion> toPromotions(List<PromotionEntity> promotionEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "dateStart", ignore = true),
            @Mapping(target = "dateEnd", ignore = true)
    })
    PromotionEntity toProductEntity(Promotion promotion);

}
