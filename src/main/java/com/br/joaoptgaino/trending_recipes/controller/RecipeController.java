package com.br.joaoptgaino.trending_recipes.controller;

import com.br.joaoptgaino.trending_recipes.dto.RecipeDTO;
import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import com.br.joaoptgaino.trending_recipes.services.RecipeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
@Slf4j
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<Page<RecipeDTO>> findAll(@PageableDefault(sort = {"position"}, direction = Sort.Direction.ASC) Pageable pageable) {
        log.info("RecipeController.findAll - Start - Pageable [{}]", pageable);
        Page<RecipeDTO> recipes = recipeService.findAll(pageable);
        ResponseEntity<Page<RecipeDTO>> response = ResponseEntity.ok(recipes);
        log.info("RecipeController.findAll - End - Pageable [{}], Recipes [{}]", pageable, recipes);
        return response;
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<RecipeDTO>> findAllWithFilters(@PageableDefault Pageable pageable, @Valid RecipeParamsDTO paramsDTO) {
        log.info("RecipeController.findAllWithFilters - Start - Pageable [{}], ParamsDTO [{}]", pageable, paramsDTO);
        Page<RecipeDTO> recipes = recipeService.findAllWithFilters(pageable, paramsDTO);
        ResponseEntity<Page<RecipeDTO>> response = ResponseEntity.ok(recipes);
        log.info("RecipeController.findAllWithFilters - End - Pageable [{}], Recipes [{}]", pageable, recipes.getContent());
        return response;
    }
}
