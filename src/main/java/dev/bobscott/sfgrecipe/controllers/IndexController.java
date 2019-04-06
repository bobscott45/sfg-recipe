package dev.bobscott.sfgrecipe.controllers;

import dev.bobscott.sfgrecipe.domain.Category;
import dev.bobscott.sfgrecipe.domain.UnitOfMeasure;
import dev.bobscott.sfgrecipe.repositories.CategoryRepository;
import dev.bobscott.sfgrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/", "index"})
    public String getIndex() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is " + categoryOptional.get().getId());
        System.out.println("Uom id is " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
