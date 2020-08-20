package com.fh.FilesSecret.controller;


import com.fh.FilesSecret.model.Secret;
import com.fh.FilesSecret.service.SecretService;
import com.fh.commom.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secret")
public class SecretController {

    @Autowired
    private SecretService secretserver;

    //查询密级
    @RequestMapping("querysecret")
    public ServerResponse querysecret(){
        return secretserver.querysecret();
    }

    //添加密级
    @RequestMapping("addsecret")
    public ServerResponse addsecret(Secret sec){
        return secretserver.addsecret(sec);
    }

    //回显密级
    @RequestMapping("huixiansecret")
    public ServerResponse huixiansecret(@RequestParam("id") Integer secid){
        return secretserver.huixiansecret(secid);
    }

    //修改密级
    @RequestMapping("updatesecret")
    public ServerResponse updatesecret(Secret sec){
        return secretserver.updatesecret(sec);
    }

    //删除密级
    @RequestMapping("deletsecret")
    public ServerResponse deletsecret(Integer secid){
        return secretserver.deletsecret(secid);
    }
}
