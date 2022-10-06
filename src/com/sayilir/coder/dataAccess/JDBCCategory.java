package com.sayilir.coder.dataAccess;

import com.sayilir.coder.entities.Category;

import java.util.List;

public class JDBCCategory implements BaseDao<Category>{
    private final List<Category> categories;

    public JDBCCategory(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public void save(Category category) {
        categories.add(category);
        System.out.println("Saved " + category.getName() + " category into JDBC.");
    }

    @Override
    public List<Category> getAll() {

        return categories;

    }
    public void printAll(){
        System.out.println("***All Categories*** \n -----------------");
        for (Category category:categories
        ) {
            System.out.println(category.getId()+" - "+category.getName());
        }
    }

    @Override
    public void delete(int id) {
        categories.remove(categories.get(id));
    }

    @Override
    public Category update(int id, Category category) {
        int index = id - 1;
        Category newCategory = categories.get(index);
        newCategory.setName(category.getName());
        return newCategory;
    }
}
