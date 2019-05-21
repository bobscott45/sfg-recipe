package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.services.RecipeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "index"})
    public String getIndex(Model model) {

        model.addAttribute("recipes", recipeService.getRecipeList());
        return "index";
    }

}
