package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UnitOfMeasureToDtoTest {

    private Long id;
    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        description = "A description";
    }

    @Test
    public void mapNullToDto() {
        assertNull(UnitOfMeasureMapper.INSTANCE.unitOfMeasureToDto(null));
    }

    @Test
    public void mapEmptyUnitOfMeasureToDto() {
        assertNotNull(UnitOfMeasureMapper.INSTANCE.unitOfMeasureToDto(new UnitOfMeasure()));
    }

    @Test
    public void mapUnitOfMeasureToDto() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(description);
        uom.setId(id);

        UnitOfMeasureDto unitOfMeasureDto = UnitOfMeasureMapper.INSTANCE.unitOfMeasureToDto(uom);

        assertEquals(id, unitOfMeasureDto.getId());
        assertEquals(description, unitOfMeasureDto.getDescription());
    }
}
