package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.domain.Recipe;

import dev.bobscott.sfgrecipe.services.RecipeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.ui.Model;


import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
    public void getIndexTest() {

        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipes.add(recipe2);

        ArgumentCaptor<Set<Recipe>> argument = ArgumentCaptor.forClass(Set.class);

        Mockito.when(recipeService.getRecipeList()).thenReturn(recipes);

        assertTrue("index".equals(controller.getIndex(model)));
        Mockito.verify(recipeService).getRecipeList();
        verify(model).addAttribute(eq("recipes"), argument.capture());
        assertEquals(2, argument.getValue().size());
    }
}