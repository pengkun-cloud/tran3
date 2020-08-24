package com.fh.MarketManagement.model;

public class Market {

    private Integer marId;//市场管理id

    private String marName;//档案号

    private String marArea;//考察市场地址

    private String marParticulars;//考察详情

    //===========================
    public Integer getMarId() {
        return marId;
    }

    public void setMarId(Integer marId) {
        this.marId = marId;
    }

    public String getMarName() {
        return marName;
    }

    public void setMarName(String marName) {
        this.marName = marName;
    }

    public String getMarArea() {
        return marArea;
    }

    public void setMarArea(String marArea) {
        this.marArea = marArea;
    }

    public String getMarParticulars() {
        return marParticulars;
    }

    public void setMarParticulars(String marParticulars) {
        this.marParticulars = marParticulars;
    }
}
