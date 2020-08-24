package com.fh.filter;

import com.fh.util.JwtUtil;
import com.fh.util.RedisUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoginFilter extends ZuulFilter {

    @Value("${check.urls}")
    private String[] urls;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        String uri = request.getRequestURI();

        for (String url : urls) {
            if(uri.contains(url)){
                return true;
            }
        }

       /* ///apigateway/order/api/v1/order/test
        System.out.println(request.getRequestURI());
        //http://127.0.0.1:9000/apigateway/order/api/v1/order/test
        System.out.println(request.getRequestURL());

        //ACL: 访问控制列表
        //不需要拦截的接口
        List<String> noFIlter = new ArrayList<>();
        noFIlter.add("/people/role/**");

        AntPathMatcher matcher = new AntPathMatcher();
        for (String pattern : noFIlter) {//pattern--/user/**
            if (StringUtils.isNotEmpty(pattern)
                    && matcher.match(pattern, request.getRequestURI())) {
                return false;
            }
        }*/

        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //获取zuul提供的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();
        //获取response对象
        HttpServletResponse response = context.getResponse();

        //处理客户端传过来的自定义头信息
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"x-auth,mtoken,content-type");
        //处理客户端发过来的put，delete
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"PUT,POST,DELETE,GET");


        //【request请求】 获取请求头中的token
        String token = request.getHeader("x-auth");
        //如果没有token 则跳转到登陆页面
        if (StringUtils.isEmpty(token)){
            //抛出异常
            //throw new LoginException();
        }
        //验证是否过期
        boolean exist = RedisUtil.exist(token);
        if(!exist){
            //throw new LoginException();
        }

        //验证token
        boolean res = JwtUtil.verify(token);
        //当res == true是进入 else 抛出异常
        if (res){
            //获取token
            String userString = JwtUtil.getUser(token);

            request.getSession().setAttribute("usertoken",userString);


            //解析token
            /*String userJson = URLDecoder.decode(userString, "utf-8");
            Member member = JSONObject.parseObject(userJson, Member.class);*/
        }else {
            //throw new LoginException();
        }



        return null;
    }
}
