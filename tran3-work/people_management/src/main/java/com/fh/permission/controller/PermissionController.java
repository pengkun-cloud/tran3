package com.fh.permission.controller;

import com.fh.common.ServerResponse;
import com.fh.permission.medol.Permission;
import com.fh.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("permission")
@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("queryPermission")
    public ServerResponse queryPermission(){
        return permissionService.queryPermission();
    }

    @RequestMapping("addOrUpdate")
    private ServerResponse addOrUpdate(Permission permission){
        if(permission.getId()!=null){
            permissionService.updatePermission(permission);
        }else{
            permissionService.addPermission(permission);
        }
        return ServerResponse.scuess();
    }


    @RequestMapping("delPermission")
    public ServerResponse delPermission(Integer id){
        permissionService.delPermission(id);
        return ServerResponse.scuess();
    }
}
