package com.fourlands.persistence.mapper;

import com.fourlands.domain.dto.Product;
import com.fourlands.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "idProduct"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "categoryEntity", target = "category")
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "orderDetailEntities", ignore = true),
            @Mapping(target = "reviewEntities", ignore = true),
            @Mapping(target = "productPromotionEntities", ignore = true),
            @Mapping(target = "imageUrl", ignore = true)
    })
    ProductEntity toProductEntity(Product product);
}
