package dev.bobscott.sfgrecipe.repositories;

import dev.bobscott.sfgrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    @Override
    Set<Recipe> findAll();
}
