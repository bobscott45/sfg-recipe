package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.*;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import dev.bobscott.sfgrecipe.dto.IngredientDto;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import dev.bobscott.sfgrecipe.dto.RecipeDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;


public class RecipeToDtoTest {

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
        assertNull(RecipeMapper.INSTANCE.recipeToDto(null));
    }

    @Test
    public void mapEmptyRecipeToDto() {
        assertNotNull(RecipeMapper.INSTANCE.recipeToDto(new Recipe()));
    }

    @Test
    public void mapRecipeToDto() {
        ingredient = new Ingredient();
        ingredient.setId(id);
        note = new Note();
        note.setId(id);
        category = new Category();
        category.setId(id);
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setDescription(description);
        recipe.setPrepTime(prepTime);
        recipe.setCookTime(cookTime);
        recipe.setServings(servings);
        recipe.setSource(source);
        recipe.setUrl(url);
        recipe.setDirections(directions);
        recipe.getIngredients().add(ingredient);
        recipe.setNote(note);
        recipe.getCategories().add(category);

        RecipeDto RecipeDto = RecipeMapper.INSTANCE.recipeToDto(recipe);

        assertEquals(id, RecipeDto.getId());
        assertEquals(description, RecipeDto.getDescription());
        assertEquals(prepTime, RecipeDto.getPrepTime());
        assertEquals(cookTime, RecipeDto.getCookTime());
        assertEquals(servings, RecipeDto.getServings());
        assertEquals(source, RecipeDto.getSource());
        assertEquals(url, RecipeDto.getUrl());
        assertEquals(directions, RecipeDto.getDirections());
        assertEquals(recipe.getIngredients().size(), RecipeDto.getIngredients().size());
        assertEquals(recipe.getNote().getText(), RecipeDto.getNote().getText());
        assertEquals(recipe.getCategories().size(), RecipeDto.getCategories().size());
    }

}
