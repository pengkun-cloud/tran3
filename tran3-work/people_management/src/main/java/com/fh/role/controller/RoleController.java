package com.fh.role.controller;

import com.fh.common.ServerResponse;
import com.fh.role.model.Role;
import com.fh.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("queryRole")
    public ServerResponse queryRole(){
        return roleService.queryRole();
    }

    @RequestMapping("addOrUpdate")
    public ServerResponse addOrUpdate(Role role){
        if(role.getRoleid()!=null){
            roleService.updateRole(role);
        }else{
            roleService.addRole(role);
        }
        return ServerResponse.scuess();
    }
    @RequestMapping("delRole")
    public ServerResponse delRole(Integer roleid){
        roleService.delRole(roleid);
        return ServerResponse.scuess();
    }

}
