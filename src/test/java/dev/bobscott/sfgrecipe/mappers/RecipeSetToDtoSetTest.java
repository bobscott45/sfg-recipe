package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.*;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import dev.bobscott.sfgrecipe.dto.RecipeDto;
import dev.bobscott.sfgrecipe.dto.IngredientDto;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class RecipeSetToDtoSetTest {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;

    @Mock Ingredient ingredient;
    @Mock IngredientDto ingredientDto;

    @Mock Category category;
    @Mock CategoryDto categoryDto;

    @Mock Note note;
    @Mock NoteDto noteDto;



    @Before
    public void SetUp() {

        id = 42L;
        description = "Some description";
        prepTime = 10;
        cookTime = 15;
        servings = 4;
        source = "Some source";
        url = "Some url";
        directions = "Some directions";
        difficulty = Difficulty.EASY;
    }

    @Test
    public void mapNullToDto() {
        assertNull(RecipeMapper.INSTANCE.recipeSetToDtoSet(null));
    }

    @Test
    public void mapEmptyRecipeSetToDtoSet() {
        assertNotNull(RecipeMapper.INSTANCE.recipeSetToDtoSet(new HashSet<Recipe>()));
    }

    @Test
    public void mapRecipeSetToDtoSet() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Recipe 1");
        recipes.add(recipe1);
        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Recipe 2");
        recipes.add(recipe2);

        Set<RecipeDto> recipeDtos = RecipeMapper.INSTANCE.recipeSetToDtoSet(recipes);

        assertEquals(recipes.size(), recipeDtos.size());
        assertTrue(recipeDtos.contains(RecipeMapper.INSTANCE.recipeToDto(recipe1)));
        assertTrue(recipeDtos.contains(RecipeMapper.INSTANCE.recipeToDto(recipe2)));
    }

}
