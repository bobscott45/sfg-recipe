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


public class DtoToRecipeTest {

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
    public void mapNullToRecipe() {
        assertNull(RecipeMapper.INSTANCE.dtoToRecipe(null));
    }

    @Test
    public void mapEmptyDtoToRecipe() {
        assertNotNull(RecipeMapper.INSTANCE.dtoToRecipe(new RecipeDto()));
    }


    @Test
    public void mapDtoToRecipe() {
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

        Recipe recipe = RecipeMapper.INSTANCE.dtoToRecipe(dto);

        assertNotNull(recipe);
        assertEquals(id, recipe.getId());
        assertEquals(description, recipe.getDescription());
    }

}
