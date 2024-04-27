package raiper.com.ecomerce.controller;

import org.springframework.web.bind.annotation.*;
import raiper.com.ecomerce.dto.converter.entityToDto.ConverterCategoryToDto;
import raiper.com.ecomerce.model.Category;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;
import raiper.com.ecomerce.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;
    private ConverterCategoryToDto converterCategoryToDTO;


    public CategoryController(CategoryService categoryService,
                              ConverterCategoryToDto converterCategoryToDTO) {
        this.categoryService = categoryService;
        this.converterCategoryToDTO = converterCategoryToDTO;
    }

    @GetMapping
    public Result getAllCategories() {
        var categories = categoryService.getAllCategory();
        var categoryDto =categories.stream().map(category -> converterCategoryToDTO.convert(category)).toList();
        return new Result(true, StatusCode.SUCCESS, "Find All Success", categoryDto);
    }

    @GetMapping("/{categoryId}")
    public Result getCategoryById(@RequestParam Integer categoryId) {
        return null;
    }

    @PostMapping
    public Result addNewCategory(@RequestBody Category category) {
        return null;
    }
}
