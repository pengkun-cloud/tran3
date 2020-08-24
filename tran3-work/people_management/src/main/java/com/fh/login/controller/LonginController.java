package com.fh.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.personnel.medol.Personnel;
import com.fh.personnel.service.PersonnelService;
import com.fh.util.JwtUtil;
import com.fh.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    @RequestMapping("longinPersonnel")
    public ServerResponse longinPersonnel(HttpServletRequest request) throws UnsupportedEncodingException {
        String token = request.getHeader("x-auth");
        //如果没有token 则跳转到登陆页面
        if (StringUtils.isEmpty(token)){
            //抛出异常
            return ServerResponse.erroe("头信息丢失");
        }
        //验证是否过期
        boolean exist = RedisUtil.exist(token);
        if(!exist){
            return ServerResponse.erroe("登录超时");
        }
        //验证token
        boolean res = JwtUtil.verify(token);
        //当res == true是进入 else 抛出异常
        Personnel personnel =null;
        if (res){
            //获取token
            String userString = JwtUtil.getUser(token);

            //解析token
            String userJson = URLDecoder.decode(userString, "utf-8");
          personnel = JSONObject.parseObject(userJson, Personnel.class);
        }else {
            return ServerResponse.erroe("登录超时");
        }


        return ServerResponse.scuess(personnel);
    }
}
