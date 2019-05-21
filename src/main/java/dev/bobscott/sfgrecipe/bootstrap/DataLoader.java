package dev.bobscott.sfgrecipe.bootstrap;

import dev.bobscott.sfgrecipe.domain.*;
import dev.bobscott.sfgrecipe.repositories.CategoryRepository;
import dev.bobscott.sfgrecipe.repositories.RecipeRepository;
import dev.bobscott.sfgrecipe.repositories.UnitOfMeasureRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository,
                      CategoryRepository categoryRepository,
                      UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Recipe recipe1 = new Recipe();
        Optional<Category> category = categoryRepository.findByDescription("mexican");
        if(category.isPresent()) {
            category.get().getRecipes().add(recipe1);
            recipe1.getCategories().add(category.get());
        }

        Set<Category> cats = recipe1.getCategories();

        recipe1.setDescription("How to Make Perfect Guacamole");
        recipe1.setSource("Simply Recipes");
        recipe1.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setServings(4);
        recipe1.setPrepTime(10);
        recipe1.setCookTime(0);
        recipe1.setDirections("1 Cut avocado, remove flesh\n" +
            "2 Mash with a fork\n" +
            "3 Add salt, lime juice, and the rest\n" +
            "4 Cover with plastic and chill to store\n"
          );
        recipe1.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), unitOfMeasureRepository.findByDescription("each").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), unitOfMeasureRepository.findByDescription("teaspoon").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), unitOfMeasureRepository.findByDescription("each").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), unitOfMeasureRepository.findByDescription("dash").get(), recipe1));
        recipe1.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), unitOfMeasureRepository.findByDescription("each").get(), recipe1));
        recipe1.setNote(new Note(recipe1, "Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours."));
        recipeRepository.save(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Spicy Grilled Chicken Tacos Recipe");
        recipe2.setSource("Simply Recipes");
        recipe2.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        recipe2.setDifficulty(Difficulty.EASY);
        recipe2.setServings(6);
        recipe2.setPrepTime(20);
        recipe2.setCookTime(15);
        recipe2.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
            "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder"
        );
        recipe2.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), unitOfMeasureRepository.findByDescription("teaspoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), unitOfMeasureRepository.findByDescription("teaspoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), unitOfMeasureRepository.findByDescription("teaspoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("salt", new BigDecimal(0.5), unitOfMeasureRepository.findByDescription("teaspoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), unitOfMeasureRepository.findByDescription("each").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("fresh squeezed orange juice", new BigDecimal(3), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), unitOfMeasureRepository.findByDescription("tablespoon").get(), recipe2));
        recipe2.getIngredients().add(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(6), unitOfMeasureRepository.findByDescription("each").get(), recipe2));
        recipe2.setNote(new Note(recipe2, "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"));
        recipeRepository.save(recipe2);

    }

}
