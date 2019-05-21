package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Category;
import dev.bobscott.sfgrecipe.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DtoToCategoryTest {

    private Long id;
    private String description;



    @Before
    public void SetUp() {
        id = 42L;
        description = "Some description";
    }

    @Test
    public void mapNullToDto() {
        assertNull(CategoryMapper.INSTANCE.dtoToCategory(null));
    }

    @Test
    public void mapEmptyDtoToCategory() {
        assertNotNull(CategoryMapper.INSTANCE.dtoToCategory(new CategoryDto()));
    }
    @Test
    public void mapDtoToCategory() {
        CategoryDto dto = new CategoryDto();
        dto.setId(id);
        dto.setDescription(description);

        Category category = CategoryMapper.INSTANCE.dtoToCategory(dto);

        assertNotNull(category);
        assertEquals(id, category.getId());
        assertEquals(description, category.getDescription());
    }

}
