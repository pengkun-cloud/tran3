package com.fh.Files.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.input.DataFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Record {

    private Integer recId;//档案id

    private String recName;//案卷号

    private String recLandUser;//土地使用者

    private String recStorageLife;//保存期限

    private String recRegistrationType;//登记类型

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date recRegistrationDate;//登记日期

    private BigDecimal recArea;//面积

    private Integer secretId;//密级

    private String recDepartment;//主办部门

    //=======================================


    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecLandUser() {
        return recLandUser;
    }

    public void setRecLandUser(String recLandUser) {
        this.recLandUser = recLandUser;
    }

    public String getRecStorageLife() {
        return recStorageLife;
    }

    public void setRecStorageLife(String recStorageLife) {
        this.recStorageLife = recStorageLife;
    }

    public String getRecRegistrationType() {
        return recRegistrationType;
    }

    public void setRecRegistrationType(String recRegistrationType) {
        this.recRegistrationType = recRegistrationType;
    }

    public Date getRecRegistrationDate() {
        return recRegistrationDate;
    }

    public void setRecRegistrationDate(Date recRegistrationDate) {
        this.recRegistrationDate = recRegistrationDate;
    }

    public BigDecimal getRecArea() {
        return recArea;
    }

    public void setRecArea(BigDecimal recArea) {
        this.recArea = recArea;
    }

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public String getRecDepartment() {
        return recDepartment;
    }

    public void setRecDepartment(String recDepartment) {
        this.recDepartment = recDepartment;
    }
}
