package com.br.joaoptgaino.trending_recipes.repositories.specifications;

import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import com.br.joaoptgaino.trending_recipes.entities.RecipeEntity;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import static io.micrometer.common.util.StringUtils.isNotBlank;

@UtilityClass
public class RecipeSpecification {
    public static Specification<RecipeEntity> create(RecipeParamsDTO paramsDTO) {
        return hasDifficulty(paramsDTO.difficulty());
    }

    private static Specification<RecipeEntity> hasDifficulty(String difficulty) {
        return (root, query, criteriaBuilder) -> {
            if (isNotBlank(difficulty)) {
                return criteriaBuilder.like(root.get("difficulty"), difficulty);
            }
            return null;
        };
    }
}
