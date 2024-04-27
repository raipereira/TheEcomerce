package raiper.com.ecomerce.service;

import raiper.com.ecomerce.model.Category;

import java.util.List;

public interface CategoryService {


    Category getCategoryById(Long categoryId);
    List<Category> getAllCategory();
    Category createNewCategory(Category category);
}
