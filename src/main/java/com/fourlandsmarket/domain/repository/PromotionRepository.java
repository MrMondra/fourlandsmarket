package com.fourlandsmarket.domain.repository;

import com.fourlandsmarket.domain.dto.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    List<Promotion> getAll();

    Optional<List<Promotion>> getPromotionByNameCategory(String nameCategory);

}
