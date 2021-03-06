package com.fh.personnel.medol;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_personnel")
public class Personnel {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String numbering; //用户编号

    private String name; //用户名称

    private Integer department; //用户部门

    private Integer security; //用户密级

    private Integer sex; //用户性别

    private Integer age; //用户年龄

    private String professional; //用户职称

    private Integer roleid;//用户角色

    private String password;//密码

    private String salt;//盐

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Personnel(Integer id, String numbering, String name, Integer department, Integer security, Integer sex, Integer age, String professional, Integer roleid, String password, String salt) {
        this.id = id;
        this.numbering = numbering;
        this.name = name;
        this.department = department;
        this.security = security;
        this.sex = sex;
        this.age = age;
        this.professional = professional;
        this.roleid = roleid;
        this.password = password;
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getSecurity() {
        return security;
    }

    public void setSecurity(Integer security) {
        this.security = security;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }


    public Personnel() {
    }
}
