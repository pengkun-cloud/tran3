package com.fh.role.service;

import com.fh.common.ServerResponse;
import com.fh.role.model.Role;

public interface RoleService {
    ServerResponse queryRole();

    void updateRole(Role role);

    void addRole(Role role);

    void delRole(Integer roleid);
}
