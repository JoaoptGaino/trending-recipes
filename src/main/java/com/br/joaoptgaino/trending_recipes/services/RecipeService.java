package com.br.joaoptgaino.trending_recipes.services;

import com.br.joaoptgaino.trending_recipes.dto.RecipeDTO;
import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    Page<RecipeDTO> findAllWithFilters(Pageable pageable, RecipeParamsDTO paramsDTO);

    Page<RecipeDTO> findAll(Pageable pageable);
}
