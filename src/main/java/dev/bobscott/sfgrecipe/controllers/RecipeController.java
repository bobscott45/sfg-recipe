package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService service ;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping({"/recipe/{id}", "index"})
    public String getRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", service.findById(Long.valueOf(id)));
        return "recipe/show";
    }
}
