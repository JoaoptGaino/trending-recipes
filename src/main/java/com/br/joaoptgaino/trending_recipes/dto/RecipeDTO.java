package com.br.joaoptgaino.trending_recipes.dto;

import com.br.joaoptgaino.trending_recipes.entities.RecipeEntity;
import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;

public record RecipeDTO(String name, Difficulty difficulty, Integer position, String imgUrl) {
    public RecipeDTO(RecipeEntity recipe) {
        this(recipe.getName(), recipe.getDifficulty(), recipe.getPosition(), recipe.getImgUrl());
    }

}
