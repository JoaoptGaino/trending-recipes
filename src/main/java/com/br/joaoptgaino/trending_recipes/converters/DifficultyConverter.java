package com.br.joaoptgaino.trending_recipes.converters;

import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class DifficultyConverter implements AttributeConverter<Difficulty, String> {

    @Override
    public String convertToDatabaseColumn(Difficulty difficulty) {
        if (difficulty == null) {
            return null;
        }
        return difficulty.toString();
    }

    @Override
    public Difficulty convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        for (Difficulty difficulty : Difficulty.values()) {
            if (difficulty.toString().equals(dbData)) {
                return difficulty;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + dbData);
    }
}
