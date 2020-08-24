package com.fh.send.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("t_car_send")
public class Send {

    private Integer sId;
    private String sHistory;    //派车历史编号
    private Integer sCarId;     //车辆编号
    private String sStart;   //出发地
    private String sGoal;   //目的地
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "JMT+8")
    private Date sStartDate;    //出发时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "JMT+8")
    private Date sBackDate; //返回时间
    private String sCause;  //派车原因
    private Integer sCarry; //乘客数量
    private String sRemark ;    //备注

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsHistory() {
        return sHistory;
    }

    public void setsHistory(String sHistory) {
        this.sHistory = sHistory;
    }

    public Integer getsCarId() {
        return sCarId;
    }

    public void setsCarId(Integer sCarId) {
        this.sCarId = sCarId;
    }

    public String getsStart() {
        return sStart;
    }

    public void setsStart(String sStart) {
        this.sStart = sStart;
    }

    public String getsGoal() {
        return sGoal;
    }

    public void setsGoal(String sGoal) {
        this.sGoal = sGoal;
    }

    public Date getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(Date sStartDate) {
        this.sStartDate = sStartDate;
    }

    public Date getsBackDate() {
        return sBackDate;
    }

    public void setsBackDate(Date sBackDate) {
        this.sBackDate = sBackDate;
    }

    public String getsCause() {
        return sCause;
    }

    public void setsCause(String sCause) {
        this.sCause = sCause;
    }

    public Integer getsCarry() {
        return sCarry;
    }

    public void setsCarry(Integer sCarry) {
        this.sCarry = sCarry;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark;
    }
}
