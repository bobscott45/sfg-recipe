package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "index"})
    public String getIndex(Model model) {
        log.debug("Getting index page");
        model.addAttribute("recipes", recipeService.getRecipeList());
        return "index";
    }
}
