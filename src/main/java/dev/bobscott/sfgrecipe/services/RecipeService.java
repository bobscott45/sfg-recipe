package dev.bobscott.sfgrecipe.services;


import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.dto.RecipeDto;

import java.util.Optional;
import java.util.Set;


public interface RecipeService {
    Set<RecipeDto> getRecipeList();
    RecipeDto findById(Long id);
}
