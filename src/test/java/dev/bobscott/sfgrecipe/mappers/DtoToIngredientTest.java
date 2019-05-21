package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Ingredient;
import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import dev.bobscott.sfgrecipe.dto.IngredientDto;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;


public class DtoToIngredientTest {

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
    public void mapEmptyDtoToIngredient() {
        assertNotNull(IngredientMapper.INSTANCE.dtoToIngedient(new IngredientDto()));
    }

    @Test
    public void mapDtoToIngredient() {
        IngredientDto dto = new IngredientDto();
        dto.setId(id);
        dto.setDescription(description);
        dto.setAmount(amount);
        uomDto = new UnitOfMeasureDto();
        uomDto.setId(id);
        dto.setUnitOfMeasure(uomDto);

        Ingredient ingredient = IngredientMapper.INSTANCE.dtoToIngedient(dto);

        assertEquals(id, ingredient.getId());
        assertEquals(description, ingredient.getDescription());
        assertEquals(amount, ingredient.getAmount());
        assertEquals(uomDto.getId(), ingredient.getUnitOfMeasure().getId());
    }

}
