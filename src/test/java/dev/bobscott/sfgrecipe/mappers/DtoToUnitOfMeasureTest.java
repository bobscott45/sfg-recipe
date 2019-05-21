package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DtoToUnitOfMeasureTest {

    private Long id;
    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        description = "A description";
    }

    @Test
    public void mapNullToUnitOfMeasure() {
        assertNull(UnitOfMeasureMapper.INSTANCE.dtoToUnitOfMeasure(null));
    }

    @Test
    public void mapEmptyDtoToUnitOfMeasure() {
        assertNotNull(UnitOfMeasureMapper.INSTANCE.dtoToUnitOfMeasure(new UnitOfMeasureDto()));
    }

    @Test
    public void mapDtoToUnitOfMeasure() {
        UnitOfMeasureDto dto = new UnitOfMeasureDto();
        dto.setId(id);
        dto.setDescription(description);

        UnitOfMeasure unitOfMeasure = UnitOfMeasureMapper.INSTANCE.dtoToUnitOfMeasure(dto);

        assertEquals(id, unitOfMeasure.getId());
        assertEquals(description, unitOfMeasure.getDescription());
    }

}
