package com.fourlandsmarket.graphql;

import com.fourlandsmarket.domain.dto.Promotion;
import com.fourlandsmarket.domain.service.PromotionService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class PromotionGraphQl implements GraphQLQueryResolver {
    @Autowired
    PromotionService promotionService;


    public List<Promotion> allPromotions() {
        return promotionService.getAll();
    }
}
