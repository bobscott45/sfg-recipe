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

import static org.junit.Assert.assertEquals;


public class RecipeMapperTest {

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
    public void shouldMapRecipeToDto() {
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

    @Test
    public void shouldMapDtoToRecipe() {
        ingredientDto = new IngredientDto();
        ingredientDto.setId(id);
        noteDto = new NoteDto();
        noteDto.setId(id);
        categoryDto = new CategoryDto();
        categoryDto.setId(id);
        RecipeDto dto = new RecipeDto();
        dto.setId(id);
        dto.setDescription(description);
        dto.setPrepTime(prepTime);
        dto.setCookTime(cookTime);
        dto.setServings(servings);
        dto.setSource(source);
        dto.setUrl(url);
        dto.setDirections(directions);
        dto.getIngredients().add(ingredientDto);
        dto.setNote(noteDto);
        dto.getCategories().add(categoryDto);

        Recipe Recipe = RecipeMapper.INSTANCE.dtoToRecipe(dto);

        assertEquals(id, Recipe.getId());
        assertEquals(description, Recipe.getDescription());
    }

}
