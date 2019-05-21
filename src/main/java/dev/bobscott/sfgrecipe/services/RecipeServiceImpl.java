package dev.bobscott.sfgrecipe.services;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository=recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipeList() {

        return recipeRepository.findAll();

    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(!recipe.isPresent()) throw( new RuntimeException("Recipe not found"));
        return recipe.get();
    }
}
