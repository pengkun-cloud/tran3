package com.fh.category.mapper;

import com.fh.category.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    List<Category> queryCategoryList();

    void addCategory(Category category);

    Category queryCategoryById(Integer id);

    void updateCategory(Category category);

    void deleteCategory(Integer id);

    void deleteBatchCategory(List<Integer> list);

}
