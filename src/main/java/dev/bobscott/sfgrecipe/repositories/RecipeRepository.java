package dev.bobscott.sfgrecipe.repositories;

import dev.bobscott.sfgrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
