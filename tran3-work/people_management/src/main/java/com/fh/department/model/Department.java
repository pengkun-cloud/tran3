package com.fh.department.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_department")
public class Department {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
