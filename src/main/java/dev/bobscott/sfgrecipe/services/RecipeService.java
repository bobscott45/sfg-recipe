package dev.bobscott.sfgrecipe.services;


import dev.bobscott.sfgrecipe.domain.Recipe;

import java.util.Optional;
import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipeList();
    Recipe findById(Long id);
}
