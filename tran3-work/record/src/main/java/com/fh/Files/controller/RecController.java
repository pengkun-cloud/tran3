package com.fh.Files.controller;


import com.fh.Files.model.Record;
import com.fh.Files.service.RecService;
import com.fh.commom.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("record")
public class RecController {

    @Autowired
    private RecService Recservice;

    //查询档案
    @RequestMapping("queryrecord")
    public ServerResponse queryrecord(){
        return Recservice.queryrecord();
    }

    //添加档案
    @RequestMapping("addrecord")
    public ServerResponse addrecord(Record rec){
        return Recservice.addrecord(rec);
    }

    //回显档案
    @RequestMapping("huixianecord")
    public ServerResponse huixianecord(@RequestParam("id") Integer recid){
        return Recservice.huixianecord(recid);
    }

    //修改档案
    @RequestMapping("updateecord")
    public ServerResponse updateecord(Record rec){
        return Recservice.updateecord(rec);
    }

    //删除档案
    @RequestMapping("deleteecord")
    public ServerResponse deleteecord(Integer recid){
        return Recservice.deleteecord(recid);
    }

    //批量删除
    @RequestMapping("deleteallecord")
    public ServerResponse deleteallecord(@RequestParam(value="id")List id){
        return Recservice.deleteallecord(id);
    }
}
