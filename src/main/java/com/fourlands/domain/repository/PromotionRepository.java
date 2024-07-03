package com.fourlands.domain.repository;

import com.fourlands.domain.dto.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    List<Promotion> getAll();

    Optional<List<Promotion>> getPromotionByNameCategory(String nameCategory);

}
