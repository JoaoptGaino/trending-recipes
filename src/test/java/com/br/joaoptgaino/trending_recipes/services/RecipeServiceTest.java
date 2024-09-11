package com.br.joaoptgaino.trending_recipes.services;

import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import com.br.joaoptgaino.trending_recipes.entities.RecipeEntity;
import com.br.joaoptgaino.trending_recipes.fixtures.RecipeFixture;
import com.br.joaoptgaino.trending_recipes.repositories.RecipeRepository;
import com.br.joaoptgaino.trending_recipes.repositories.specifications.RecipeSpecification;
import com.br.joaoptgaino.trending_recipes.services.impl.RecipeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Test
    void shouldFindAllRecipesSuccessfully() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "position");
        when(recipeRepository.findAll(pageable)).thenReturn(RecipeFixture.getPageRecipeEntityFixture());
        var response = recipeService.findAll(pageable);
        assertEquals(response.getTotalElements(), 1);
    }

    @Test
    void shouldFindAllWithFilterRecipesSuccessfully() {
        Pageable pageable = PageRequest.of(0, 10);
        RecipeParamsDTO paramsDTO = new RecipeParamsDTO("medium");
        when(recipeRepository.findAll((Specification<RecipeEntity>) any(), eq(pageable)))
                .thenReturn(RecipeFixture.getPageRecipeEntityFixture());
        var response = recipeService.findAllWithFilters(pageable, paramsDTO);
        assertEquals(response.getTotalElements(), 1);
    }
}
