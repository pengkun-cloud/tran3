package com.fh.role.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer roleid;

    private String rolename;

    private Integer status;

    private String pemissionid;

    public String getPemissionid() {
        return pemissionid;
    }

    public void setPemissionid(String pemissionid) {
        this.pemissionid = pemissionid;
    }

    public Role(Integer roleid, String rolename, Integer status, String pemissionid) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.status = status;
        this.pemissionid = pemissionid;
    }

    public Role(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Role() {
    }
}
