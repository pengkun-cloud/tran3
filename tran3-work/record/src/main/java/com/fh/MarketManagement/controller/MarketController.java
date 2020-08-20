package com.fh.MarketManagement.controller;


import com.fh.MarketManagement.model.Market;
import com.fh.MarketManagement.service.MarketService;
import com.fh.commom.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("market")
public class MarketController {

    @Autowired
    private MarketService marketservice;


    //查询市场管理
    @RequestMapping("querymar")
    public ServerResponse querymar(){
    return marketservice.querymar();
    }

    //添加市场管理
    @RequestMapping("addmar")
    public ServerResponse addmar(Market mar){
        return marketservice.addmar(mar);
    }

    //回显市场管理
    @RequestMapping("huixianmar")
    public ServerResponse huixianmar(Integer marid){
        return marketservice.huixianmar(marid);
    }

    //修改市场管理
    @RequestMapping("updatemar")
    public ServerResponse updatemar(Market mar){
        return marketservice.updatemar(mar);
    }

    //删除市场管理
    @RequestMapping("deletemar")
    public ServerResponse deletemar(Integer marid){
        return marketservice.deletemar(marid);
    }

    //批量删除市场管理
    @RequestMapping("deleteallmar")
    public ServerResponse deleteallmar(@RequestParam("id")List id){
        return marketservice.deleteallmar(id);
    }
}
