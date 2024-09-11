package com.br.joaoptgaino.trending_recipes.services.impl;

import com.br.joaoptgaino.trending_recipes.dto.RecipeDTO;
import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import com.br.joaoptgaino.trending_recipes.entities.RecipeEntity;
import com.br.joaoptgaino.trending_recipes.repositories.RecipeRepository;
import com.br.joaoptgaino.trending_recipes.repositories.specifications.RecipeSpecification;
import com.br.joaoptgaino.trending_recipes.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Override
    public Page<RecipeDTO> findAllWithFilters(Pageable pageable, RecipeParamsDTO paramsDTO) {
        log.info("RecipeService.findAllWithFilters - Start - Pageable [{}], RecipeParamsDTO [{}]", pageable, paramsDTO);
        Specification<RecipeEntity> specification = RecipeSpecification.create(paramsDTO);
        Page<RecipeDTO> recipes = recipeRepository
                .findAll(specification, pageable)
                .map(RecipeDTO::new);
        log.info("RecipeService.findAllWithFilters - End - Pageable [{}], Recipes [{}], RecipeParamsDTO [{}]", pageable, recipes.getTotalElements(), paramsDTO);
        return recipes;
    }

    @Override
    public Page<RecipeDTO> findAll(Pageable pageable) {
        log.info("RecipeService.findAll - Start - Pageable [{}]", pageable);
        Page<RecipeDTO> recipes = recipeRepository.findAll(pageable).map(RecipeDTO::new);
        log.info("RecipeService.findAll - End - Pageable [{}], Recipes [{}]", pageable, recipes.getTotalElements());
        return recipes;
    }
}
