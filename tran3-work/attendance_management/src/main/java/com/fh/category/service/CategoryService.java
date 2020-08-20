package com.fh.category.service;

import com.fh.category.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryList();

    void addCategory(Category category);

    Category queryCategoryById(Integer id);

    void updateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteBatchCategory(List<Integer> list);
}
