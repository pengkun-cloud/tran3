package com.fh.permission.service;

import com.fh.common.ServerResponse;
import com.fh.permission.mapper.PermissionMapper;
import com.fh.permission.medol.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public ServerResponse queryPermission() {
        Map mm=new HashMap();
        List<Permission> list = permissionMapper.queryPermission();
        mm.put("data",list);
        return ServerResponse.scuess(list);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }

    @Override
    public void addPermission(Permission permission) {
        permissionMapper.addPermission(permission);
    }

    @Override
    public void delPermission(Integer id) {
        permissionMapper.delPermission(id);
    }

}
