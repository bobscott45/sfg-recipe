package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class UnitOfMeasureMapperTest {

    private Long id;
    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        description = "A description";
    }


    @Test
    public void shouldMapUnitOfMeasureToDto() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(description);
        uom.setId(id);

        UnitOfMeasureDto unitOfMeasureDto = UnitOfMeasureMapper.INSTANCE.unitOfMeasureToDto(uom);

        assertEquals(id, unitOfMeasureDto.getId());
        assertEquals(description, unitOfMeasureDto.getDescription());
    }

    @Test
    public void shouldMapDtoToUnitOfMeasure() {
        UnitOfMeasureDto dto = new UnitOfMeasureDto();
        dto.setId(id);
        dto.setDescription(description);

        UnitOfMeasure unitOfMeasure = UnitOfMeasureMapper.INSTANCE.dtoToUnitOfMeasure(dto);

        assertEquals(id, unitOfMeasure.getId());
        assertEquals(description, unitOfMeasure.getDescription());
    }

}
