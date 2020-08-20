package com.fh.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.personnel.medol.Personnel;
import com.fh.personnel.service.PersonnelService;
import com.fh.util.JwtUtil;
import com.fh.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LonginController {

    @Autowired
    private PersonnelService personnelService;
    @RequestMapping("login")
    public ServerResponse longin(Personnel personnel) {

        Personnel personnelDB =personnelService.getPersonnelByName(personnel.getName());

        if(personnelDB==null){
            return ServerResponse.scuess("该用户不存在");
        }
        if (!personnelDB.getPassword().equals(personnel.getPassword())){
            return ServerResponse.erroe("密码不正确 请确认");
        }

        String token = null;
        try {
            String jsonString = JSONObject.toJSONString(personnelDB);
            String encodeJSON = URLEncoder.encode(jsonString, "utf-8");
            token = JwtUtil.sign(encodeJSON);
            RedisUtil.setex(token,3*60*1000,jsonString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return ServerResponse.scuess(token);
    }
}
