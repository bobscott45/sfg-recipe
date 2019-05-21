package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Ingredient;
import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.IngredientDto;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;


public class IngredientToDtoTest {

    private Long id;
    private BigDecimal amount;

    @Mock
    private UnitOfMeasure uom;

    @Mock
    UnitOfMeasureDto uomDto;

    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        amount = new BigDecimal(12.34).setScale(2, RoundingMode.HALF_UP );
        description = "A description";
    }

    @Test
    public void mapNullToDto() {
        assertNull(IngredientMapper.INSTANCE.ingredientToDto(null));
    }

    @Test
    public void mapEmptyIngredientToDto() {
        assertNotNull(IngredientMapper.INSTANCE.ingredientToDto(new Ingredient()));
    }

    @Test
    public void mapIngredientToDto() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        ingredient.setDescription(description);
        ingredient.setAmount(amount);
        uom = new UnitOfMeasure();
        uom.setId(id);
        ingredient.setUnitOfMeasure(uom);


        IngredientDto ingredientDto = IngredientMapper.INSTANCE.ingredientToDto(ingredient);

        assertEquals(id, ingredientDto.getId());
        assertEquals(description, ingredientDto.getDescription());
        assertEquals(amount, ingredientDto.getAmount());
        assertEquals(uom.getId(), ingredientDto.getUnitOfMeasure().getId());
    }

}
