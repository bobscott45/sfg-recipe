package dev.bobscott.sfgrecipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long value = 4L;
        category.setId(value);
        assertEquals(value, category.getId());
    }

    @Test
    public void getDescription() {
        String value = "Test description";
        category.setDescription(value);
        assertEquals(value, category.getDescription());
    }

    @Test
    public void getRecipes() {

    }
}