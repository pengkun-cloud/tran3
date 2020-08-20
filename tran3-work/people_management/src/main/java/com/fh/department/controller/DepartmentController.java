package com.fh.department.controller;

import com.fh.common.ServerResponse;
import com.fh.department.model.Department;
import com.fh.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
@CrossOrigin
public class DepartmentController {

   @Autowired
    private DepartmentService departmentService;

    @RequestMapping("queryDepartment")
    public ServerResponse queryDepartment(){
        return departmentService.queryDepartment();
    }

    @RequestMapping("addOrUpdate")
    public ServerResponse addOrUpdate(Department department){
        if(department.getId()!=null){
            departmentService.updateDepartment(department);
        }else{
            departmentService.addDepartment(department);
        }
        return ServerResponse.scuess();
    }
    @RequestMapping("delDepartment")
    public ServerResponse delDepartment(Integer id){
        departmentService.delDepartment(id);
        return ServerResponse.scuess();
    }

}
