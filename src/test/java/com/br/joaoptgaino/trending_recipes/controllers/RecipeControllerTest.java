package com.br.joaoptgaino.trending_recipes.controllers;

import com.br.joaoptgaino.trending_recipes.dto.RecipeDTO;
import com.br.joaoptgaino.trending_recipes.dto.RecipeParamsDTO;
import com.br.joaoptgaino.trending_recipes.fixtures.RecipeFixture;
import com.br.joaoptgaino.trending_recipes.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {
    @MockBean
    private RecipeService recipeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllRecipesShouldReturnOk() throws Exception {
        Pageable pageable = PageRequest.of(0, 10);
        Page<RecipeDTO> recipePage = RecipeFixture.getPageRecipeDTOFixture();
        when(recipeService.findAll(any(Pageable.class))).thenReturn(recipePage);

        mockMvc.perform(get("/recipes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindAllWithFiltersShouldReturnOk() throws Exception {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        RecipeParamsDTO paramsDTO = new RecipeParamsDTO("easy");
        Page<RecipeDTO> recipePage = RecipeFixture.getPageRecipeDTOFixture();
        when(recipeService.findAllWithFilters(any(Pageable.class), any(RecipeParamsDTO.class))).thenReturn(recipePage);

        // Act & Assert
        mockMvc.perform(get("/recipes/filtered")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("difficulty", "easy"))  // Simulando o parâmetro de filtro
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
