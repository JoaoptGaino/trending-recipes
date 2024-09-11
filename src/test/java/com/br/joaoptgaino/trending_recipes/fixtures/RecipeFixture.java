package com.br.joaoptgaino.trending_recipes.fixtures;

import com.br.joaoptgaino.trending_recipes.entities.RecipeEntity;
import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class RecipeFixture {
    public static Page<RecipeEntity> getPageRecipeEntityFixture() {
        return new PageImpl<>(getRecipeEntityListFixture());
    }

    public static List<RecipeEntity> getRecipeEntityListFixture() {
        return List.of(getRecipeEntityFixture());
    }

    public static RecipeEntity getRecipeEntityFixture() {
        return new RecipeEntity(1L, "Burger", Difficulty.MEDIUM, 1, "img");
    }
}
