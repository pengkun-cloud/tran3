package com.fh.garage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("t_garage")
public class Garage {

    private Integer xId;

    private String xCarId;//车辆编号

    private String xPeo;//送修人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date xTime;//送修时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jTime;//交车时间

    public Integer getxId() {
        return xId;
    }

    public void setxId(Integer xId) {
        this.xId = xId;
    }

    public String getxCarId() {
        return xCarId;
    }

    public void setxCarId(String xCarId) {
        this.xCarId = xCarId;
    }

    public String getxPeo() {
        return xPeo;
    }

    public void setxPeo(String xPeo) {
        this.xPeo = xPeo;
    }

    public Date getxTime() {
        return xTime;
    }

    public void setxTime(Date xTime) {
        this.xTime = xTime;
    }

    public Date getjTime() {
        return jTime;
    }

    public void setjTime(Date jTime) {
        this.jTime = jTime;
    }
}








