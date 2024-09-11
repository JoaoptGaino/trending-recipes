package com.br.joaoptgaino.trending_recipes.entities;

import com.br.joaoptgaino.trending_recipes.converters.DifficultyConverter;
import com.br.joaoptgaino.trending_recipes.entities.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Convert(converter = DifficultyConverter.class)
    private Difficulty difficulty;

    private Integer position;

    @Column(name = "img_url")
    private String imgUrl;
}
