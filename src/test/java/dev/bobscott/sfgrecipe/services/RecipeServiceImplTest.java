package dev.bobscott.sfgrecipe.services;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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

    @Test
    public void getRecipeById() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());

    }
}