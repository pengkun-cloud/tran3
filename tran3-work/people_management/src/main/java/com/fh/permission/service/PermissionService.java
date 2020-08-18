package com.fh.permission.service;

import com.fh.common.ServerResponse;
import com.fh.permission.medol.Permission;

import java.util.Map;

public interface PermissionService {
    ServerResponse queryPermission();

    void updatePermission(Permission permission);

    void addPermission(Permission permission);

    void delPermission(Integer id);
}
