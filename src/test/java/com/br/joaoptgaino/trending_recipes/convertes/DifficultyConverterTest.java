package com.br.joaoptgaino.trending_recipes.convertes;

import com.br.joaoptgaino.trending_recipes.converters.DifficultyConverter;
import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class DifficultyConverterTest {

    @InjectMocks
    private DifficultyConverter difficultyConverter;

    @Test
    void convertToDatabaseColumn() {
        Difficulty diff = Difficulty.EASY;
        String response = difficultyConverter.convertToDatabaseColumn(diff);
        assertEquals(response, diff.getDifficulty());
    }

    @Test
    void convertToDatabaseColumnNullDiff() {
        String response = difficultyConverter.convertToDatabaseColumn(null);
        assertNull(response);
    }

    @Test
    void convertToEntityAttribute() {
        String dbData = "medium";
        Difficulty difficulty = difficultyConverter.convertToEntityAttribute(dbData);
        assertEquals(difficulty.getDifficulty(), dbData);
    }

    @Test
    void convertToEntityAttributeNull() {
        Difficulty difficulty = difficultyConverter.convertToEntityAttribute(null);
        assertNull(difficulty);
    }

    @Test
    void convertToEntityAttributeEmpty() {
        Difficulty difficulty = difficultyConverter.convertToEntityAttribute("");
        assertNull(difficulty);
    }

    @Test
    void convertToEntityAttributeShouldThrowUnknown() {
        String dbData = "unknown";
        assertThatThrownBy(() -> difficultyConverter.convertToEntityAttribute(dbData))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
