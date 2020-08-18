package com.fh.role.mapper;

import com.fh.role.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List queryRole();

    void updateRole(Role role);

    void addRole(Role role);

    void delRole(Integer roleid);
}
