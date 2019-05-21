package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Category;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToDto(Category category);
    Category dtoToCategory(CategoryDto dto);
}
