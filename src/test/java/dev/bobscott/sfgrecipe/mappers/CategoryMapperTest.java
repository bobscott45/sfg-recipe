package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Category;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CategoryMapperTest {

    private Long id;
    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        description = "Some description";
    }


    @Test
    public void shouldMapCategoryToDto() {
        Category Category = new Category();
        Category.setDescription(description);
        Category.setId(id);

        CategoryDto CategoryDto = CategoryMapper.INSTANCE.categoryToDto(Category);

        assertEquals(id, CategoryDto.getId());
        assertEquals(description, CategoryDto.getDescription());
    }

    @Test
    public void shouldMapDtoToCategory() {
        CategoryDto dto = new CategoryDto();
        dto.setId(id);
        dto.setDescription(description);

        Category Category = CategoryMapper.INSTANCE.dtoToCategory(dto);

        assertEquals(id, Category.getId());
        assertEquals(description, Category.getDescription());
    }

}
