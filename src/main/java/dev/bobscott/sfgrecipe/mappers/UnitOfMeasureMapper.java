package dev.bobscott.sfgrecipe.mappers;


import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.dto.UnitOfMeasureDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitOfMeasureMapper {
    UnitOfMeasureMapper INSTANCE = Mappers.getMapper(UnitOfMeasureMapper.class);

    UnitOfMeasureDto unitOfMeasureToDto(UnitOfMeasure unitOfMeasure);
    UnitOfMeasure dtoToUnitOfMeasure(UnitOfMeasureDto unitOfMeasureDto);
}
