package com.fh.permission.mapper;

import com.fh.permission.medol.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> queryPermission();

    void updatePermission(Permission permission);

    void addPermission(Permission permission);

    void delPermission(Integer id);
}
