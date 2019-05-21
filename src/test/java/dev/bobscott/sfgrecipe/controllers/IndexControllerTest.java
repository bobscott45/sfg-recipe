package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.domain.Recipe;

import dev.bobscott.sfgrecipe.dto.RecipeDto;
import dev.bobscott.sfgrecipe.services.RecipeService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;


import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController controller;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
    }

    @Test
    public void getIndexTest() {

        Set<RecipeDto> recipes = new HashSet<>();
        RecipeDto recipe1 = new RecipeDto();
        recipe1.setId(1L);
        recipe1.setDescription("Recipe 1");
        recipes.add(recipe1);


        RecipeDto recipe2 = new RecipeDto();
        recipe2.setId(2L);
        recipe2.setDescription("Recipe 2");
        recipes.add(recipe2);

        ArgumentCaptor<Set<Recipe>> argument = ArgumentCaptor.forClass(Set.class);

        Mockito.when(recipeService.getRecipeList()).thenReturn(recipes);

        assertTrue("index".equals(controller.getIndex(model)));
        Mockito.verify(recipeService).getRecipeList();
        verify(model).addAttribute(eq("recipes"), argument.capture());
        assertEquals(2, argument.getValue().size());
    }
}