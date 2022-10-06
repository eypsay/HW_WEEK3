package com.sayilir.coder.service;

import com.sayilir.coder.dataAccess.BaseDao;
import com.sayilir.coder.entities.Category;
import com.sayilir.coder.logging.Logger;

import java.util.List;

public class CategoryService {

    private final BaseDao<Category> categoryDao;
    private final List<Category> categories;
    private final List<Logger> loggers;

    public CategoryService(BaseDao categoryDao, List<Category> categories, List<Logger> loggers) {
        this.categoryDao = categoryDao;
        this.categories = categories;
        this.loggers = loggers;
    }

    public void add(Category category) {
        if (checkCategoryName(category)) {
            System.out.println("\nGirilen " + category.getName() + " Category ismi tekrar edemez!!!\n");
        } else {

            categoryDao.save(category);
            categoryDao.printAll();
            loggingProcess(category);

        }
    }


    private boolean checkCategoryName(Category category) {
        List<Category> categories = categoryDao.getAll();
        for (Category daoCategory : categories
        ) {
            if (daoCategory.getName().equals(category.getName())) return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = id - 1;
        Category category = categoryDao.getAll().get(index);
        categoryDao.printAll();
        categoryDao.delete(index);
        System.out.println("Deleted for id:" + category.getId() + " -- Name: " + category.getName() + ". New category list:");
        categoryDao.printAll();
        loggingProcess(category);
    }

    public void update(int id, Category category) {
        int index = id - 1;
        String oldCategoryName = categoryDao.getAll().get(index).getName();
        Category newCategory = categoryDao.update(id, category);
        System.out.println("\n" + oldCategoryName + " category name updated with new name: " + newCategory.getName() + ". New category list:");
        categoryDao.printAll();
        loggingProcess(newCategory);

    }

    private void loggingProcess(Category category) {
        for (Logger logger : loggers
        ) {
            logger.log(category.getName());
        }
    }
}
