package com.fh.department.mapper;

import com.fh.department.model.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List queryDepartment();

    void updateDepartment(Department department);

    void addDepartment(Department department);

    void delDepartment(Integer id);
}
