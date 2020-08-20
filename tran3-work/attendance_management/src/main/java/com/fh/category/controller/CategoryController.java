package com.fh.category.controller;

import com.fh.category.model.Category;
import com.fh.category.service.CategoryService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("queryCategoryList")
    public ServerResponse queryCategoryList(){
        List<Category> list = categoryService.queryCategoryList();
        return ServerResponse.scuess(list);
    }

    @RequestMapping("addCategory")
    public ServerResponse addCategory(Category category){
        categoryService.addCategory(category);
        return ServerResponse.scuess();
    }

    @RequestMapping("queryCategoryById")
    public ServerResponse queryCategoryById(Integer id){
        Category category = categoryService.queryCategoryById(id);
        return ServerResponse.scuess(category);
    }

    @RequestMapping("updateCategory")
    public ServerResponse updateCategory(Category category){
        categoryService.updateCategory(category);
        return ServerResponse.scuess();
    }

    @RequestMapping("deleteCategory")
    public ServerResponse deleteCategory(Integer id){
        categoryService.deleteCategory(id);
        return ServerResponse.scuess();
    }

    @RequestMapping("deleteBatchCategory")
    public ServerResponse deleteBatchCategory(@RequestParam("ids") List<Integer> list){
        categoryService.deleteBatchCategory(list);
        return ServerResponse.scuess();
    }

}
