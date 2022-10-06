package com.sayilir.coder.bussiness;

import com.sayilir.coder.entities.Category;
import com.sayilir.coder.service.CategoryService;

public class CategoryManager implements BaseManager<Category> {
    private final CategoryService categoryService;

    public CategoryManager(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public void add(Category category) {
        categoryService.add(category);
    }

    public void delete(int id) {
        categoryService.delete(id);
    }

    @Override
    public void update(int id, Category category) {
        categoryService.update(id, category);
    }

}
