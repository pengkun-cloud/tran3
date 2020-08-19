package com.fh.FilesSecret.model;

public class Secret {

    private Integer secId;//密级id

    private String secName;//密级名称

    private Integer secret;//密级等级

    //=======================================
    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public Integer getSecret() {
        return secret;
    }

    public void setSecret(Integer secret) {
        this.secret = secret;
    }
}
