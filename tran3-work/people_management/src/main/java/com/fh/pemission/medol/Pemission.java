package com.fh.pemission.medol;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_pemission")
public class Pemission {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String url;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pemission(Integer id, Integer pid, String url, String name) {
        this.id = id;
        this.pid = pid;
        this.url = url;
        this.name = name;
    }

    public Pemission() {
    }
}
