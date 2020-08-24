package com.fh.car.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_car_message")
public class Car {
    private Integer cId;     //id
    private String carId;   //车辆编号
    private String carPlate;   //车牌号
    private Integer carType;   //品牌类型
    private String carStructure;   //结构特点
    private Integer carCarry;   //载客数量
    private String carFuel;  //燃料
    private Double carEmissions;   //排放等级
    private String carColor;   //颜色
    private String carRemark;   //备注
    @TableField(exist=false)
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getCarStructure() {
        return carStructure;
    }

    public void setCarStructure(String carStructure) {
        this.carStructure = carStructure;
    }

    public Integer getCarCarry() {
        return carCarry;
    }

    public void setCarCarry(Integer carCarry) {
        this.carCarry = carCarry;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public Double getCarEmissions() {
        return carEmissions;
    }

    public void setCarEmissions(Double carEmissions) {
        this.carEmissions = carEmissions;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarRemark() {
        return carRemark;
    }

    public void setCarRemark(String carRemark) {
        this.carRemark = carRemark;
    }
}
