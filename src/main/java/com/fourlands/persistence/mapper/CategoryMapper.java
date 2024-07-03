package com.fourlands.persistence.mapper;

import com.fourlands.domain.dto.Category;
import com.fourlands.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "idCategory"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "productEntities", ignore = true),
            @Mapping(target = "categoryPromotionEntities", ignore = true),
            @Mapping(target = "image_url", ignore = true)
    })
    CategoryEntity toCategoryEntity(Category category);
}
