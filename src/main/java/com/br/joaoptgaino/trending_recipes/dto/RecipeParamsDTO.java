package com.br.joaoptgaino.trending_recipes.dto;

import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;
import jakarta.validation.constraints.NotBlank;

public record RecipeParamsDTO(
        @NotBlank(message = "A difficulty is required for filtering trending recipes")
        String difficulty
) {
}
