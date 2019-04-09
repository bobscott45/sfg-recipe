package dev.bobscott.sfgrecipe.services;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
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
}
