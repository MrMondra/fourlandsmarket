package com.fourlandsmarket.persistence.mapper;

import com.fourlandsmarket.domain.dto.Category;
import com.fourlandsmarket.persistence.entity.CategoryPromotionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, PromotionMapper.class, ProductMapper.class})
public interface CategoryPromotionMapper {

    @Mappings({
            @Mapping(source = "categoryEntity.idCategory", target = "idCategory"),
            @Mapping(source = "categoryEntity.name", target = "name"),
            @Mapping(source = "categoryEntity.description", target = "description")
    })
    Category toCategory(CategoryPromotionEntity categoryPromotionEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "promotionEntity", ignore = true)
    })
    CategoryPromotionEntity toCategoryPromotionEntity(Category category);
}
