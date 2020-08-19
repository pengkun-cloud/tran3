package com.fh.department.service;

import com.fh.common.ServerResponse;
import com.fh.department.model.Department;

public interface DepartmentService {
    ServerResponse queryDepartment();

    void updateDepartment(Department department);

    void addDepartment(Department department);

    void delDepartment(Integer id);
}
