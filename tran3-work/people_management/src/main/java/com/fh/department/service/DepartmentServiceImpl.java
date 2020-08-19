package com.fh.department.service;

import com.fh.common.ServerResponse;
import com.fh.department.mapper.DepartmentMapper;
import com.fh.department.model.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public ServerResponse queryDepartment() {
        List list = departmentMapper.queryDepartment();
        return ServerResponse.scuess(list);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void delDepartment(Integer id) {
        departmentMapper.delDepartment(id);
    }
}
