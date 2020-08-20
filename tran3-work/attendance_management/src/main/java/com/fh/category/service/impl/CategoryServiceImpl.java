package com.fh.category.service.impl;

import com.fh.category.mapper.CategoryMapper;
import com.fh.category.model.Category;
import com.fh.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryList() {
        return categoryMapper.queryCategoryList();
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public Category queryCategoryById(Integer id) {
        return categoryMapper.queryCategoryById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }

    @Override
    public void deleteBatchCategory(List<Integer> list) {
        categoryMapper.deleteBatchCategory(list);
    }
}
