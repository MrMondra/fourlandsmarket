package com.fourlands.graphql;

import com.fourlands.domain.dto.Product;
import com.fourlands.domain.dto.Promotion;
import com.fourlands.domain.service.ProductService;
import com.fourlands.domain.service.PromotionService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Component
public class PromotionGraphQl implements GraphQLQueryResolver {
    @Autowired
    PromotionService promotionService;

    @Autowired
    ProductService productService;


    public List<Promotion> allPromotions() {

        return promotionService.getAll();
    }

    public List<Product> getProductByCategory(Integer idCategory) {
        return productService.getByCategory(idCategory).orElse(Collections.emptyList());
    }
}
