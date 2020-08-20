package com.fh.attendance.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {

    private Integer id;

    private String roleName; // 姓名

    private String attCoding; // 编码

    private Integer attDays; // 天数

    private Integer attManHour; // 工时

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date attWriteTime; // 记录时间

    private String attExplain; // 备注说明

    private Integer category; // 类别
    private String categoryName; // 类别名称

    private Integer department; // 部门
    private String departmentName; // 部门名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAttCoding() {
        return attCoding;
    }

    public void setAttCoding(String attCoding) {
        this.attCoding = attCoding;
    }

    public Integer getAttDays() {
        return attDays;
    }

    public void setAttDays(Integer attDays) {
        this.attDays = attDays;
    }

    public Integer getAttManHour() {
        return attManHour;
    }

    public void setAttManHour(Integer attManHour) {
        this.attManHour = attManHour;
    }

    public Date getAttWriteTime() {
        return attWriteTime;
    }

    public void setAttWriteTime(Date attWriteTime) {
        this.attWriteTime = attWriteTime;
    }

    public String getAttExplain() {
        return attExplain;
    }

    public void setAttExplain(String attExplain) {
        this.attExplain = attExplain;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
