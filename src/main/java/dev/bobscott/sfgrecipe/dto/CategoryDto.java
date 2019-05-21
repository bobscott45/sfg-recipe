package dev.bobscott.sfgrecipe.dto;

import java.util.Objects;
import java.util.Set;

public class CategoryDto {
    private Long id;
    private String description;
    private Set<RecipeDto> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RecipeDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeDto> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
