package com.fh.role.service;

import com.fh.common.ServerResponse;
import com.fh.role.mapper.RoleMapper;
import com.fh.role.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public ServerResponse queryRole() {
        List list = roleMapper.queryRole();
        return ServerResponse.scuess(list);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void delRole(Integer roleid) {
        roleMapper.delRole(roleid);
    }
}
