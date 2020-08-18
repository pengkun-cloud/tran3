package com.fh.common;

public class ServerResponse {

    private Integer code;
    private String msg;
    private Object data;

    public static ServerResponse scuess(Object data){
        return new ServerResponse(200,"操作成功",data);
    }
    public static ServerResponse scuess(){
        return new ServerResponse(200,"操作成功");
    }
    public static ServerResponse erroe(){
        return new ServerResponse(1,"操作失败");
    }
    public static ServerResponse erroe(Object data){
        return new ServerResponse(1,"操作失败");
    }

    public ServerResponse() {
    }

    public ServerResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
