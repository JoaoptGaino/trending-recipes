package com.br.joaoptgaino.trending_recipes.entities.enums;

import lombok.Getter;

@Getter
public enum Difficulty {

    EASY("easy"),

    MEDIUM("medium"),

    HARD("hard");

    private final String difficulty;

    Difficulty(String diff) {
        this.difficulty = diff;
    }

    @Override
    public String toString() {
        return this.difficulty;
    }
}
