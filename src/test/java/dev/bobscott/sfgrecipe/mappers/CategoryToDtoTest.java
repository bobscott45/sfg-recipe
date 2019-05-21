package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Category;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CategoryToDtoTest {

    private Long id;
    private String description;





    @Before
    public void SetUp() {
        id = 42L;
        description = "Some description";
    }

    @Test
    public void mapNullToDto() {
        assertNull(CategoryMapper.INSTANCE.categoryToDto(null));
    }

    @Test
    public void mapEmptyCategoryToDto() {
        assertNotNull(CategoryMapper.INSTANCE.categoryToDto(new Category()));
    }


    @Test
    public void mapCategoryToDto() {
        Category category = new Category();
        category.setDescription(description);
        category.setId(id);

        CategoryDto categoryDto = CategoryMapper.INSTANCE.categoryToDto(category);

        assertNotNull(categoryDto);
        assertEquals(id, categoryDto.getId());
        assertEquals(description, categoryDto.getDescription());
    }
}
