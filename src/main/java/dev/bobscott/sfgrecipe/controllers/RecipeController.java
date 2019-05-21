package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.domain.Recipe;
import dev.bobscott.sfgrecipe.dto.RecipeDto;
import dev.bobscott.sfgrecipe.mappers.RecipeMapper;
import dev.bobscott.sfgrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService service ;
    private final RecipeMapper mapper;

    public RecipeController(RecipeService service, RecipeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping({"/recipe/{id}", "index"})
    public String getRecipe(@PathVariable String id, Model model) {
        RecipeDto recipeDto = service.findById(Long.valueOf(id));
        model.addAttribute("recipe", recipeDto);
        return "recipe/show";
    }
}
