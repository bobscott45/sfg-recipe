package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.dto.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto recipeToDto(Recipe recipe);
    Recipe dtoToRecipe(RecipeDto dto);
}
