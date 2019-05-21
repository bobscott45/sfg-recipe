package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Ingredient;
import dev.bobscott.sfgrecipe.dto.IngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientDto ingredientToDto(Ingredient ingredient);
    Ingredient dtoToIngedient(IngredientDto dto);
}
