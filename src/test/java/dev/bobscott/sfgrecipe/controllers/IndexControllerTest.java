package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.domain.Recipe;

import dev.bobscott.sfgrecipe.services.RecipeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.ui.Model;


import java.util.HashSet;


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

        Mockito.when(recipeService.getRecipeList()).thenReturn(new HashSet<Recipe>());

        assertTrue("index".equals(controller.getIndex(model)));
        Mockito.verify(recipeService).getRecipeList();
        verify(model).addAttribute(eq("recipes"), anySet());

    }
}