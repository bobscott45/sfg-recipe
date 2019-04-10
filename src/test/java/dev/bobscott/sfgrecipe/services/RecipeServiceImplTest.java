package dev.bobscott.sfgrecipe.services;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipeList() {
        Set<Recipe> recipeData = new HashSet();
        recipeData.add(new Recipe());

        when(recipeService.getRecipeList()).thenReturn(recipeData);

        assertEquals(recipeData.size(), recipeService.getRecipeList().size());

    }
}