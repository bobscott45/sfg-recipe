package dev.bobscott.sfgrecipe.services;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.dto.RecipeDto;
import dev.bobscott.sfgrecipe.mappers.RecipeMapper;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;

import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;


@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public Set<RecipeDto> getRecipeList() {

        Set<Recipe> recipes = recipeRepository.findAll();
        return recipeMapper.recipeSetToDtoSet(recipes);
    }

    @Override
    public RecipeDto findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(!recipe.isPresent()) throw( new RuntimeException("Recipe not found"));
        return recipeMapper.recipeToDto(recipe.get());
    }
}
