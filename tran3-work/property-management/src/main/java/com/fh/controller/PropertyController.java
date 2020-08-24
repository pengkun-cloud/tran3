package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Property;
import com.fh.model.PropertyQuery;
import com.fh.model.Types;
import com.fh.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("property")
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    //查询大表数据
    @RequestMapping("queryProperty")
    public ServerResponse queryProperty(PropertyQuery propertyQuery){
        long totalCount =  propertyService.selectCountt(propertyQuery);
        List<Property> list = propertyService.queryProperty(propertyQuery);
        Map<String,Object> map =new HashMap();
        map.put("totalCount",totalCount);
        map.put("list",list);
        return ServerResponse.success(map);
    }

    //查询小表数据
    @RequestMapping("queryType")
    public ServerResponse queryType(){
        List<Types> typeList = propertyService.queryType();
        return ServerResponse.success(typeList);
    }

    //添加数据
    @RequestMapping("addProperty")
    public ServerResponse addProperty(Property property){
        propertyService.addProperty(property);
        return ServerResponse.success();
    }

    //删除数据
    @RequestMapping("deleteProperty")
    public ServerResponse deleteProperty(Integer id){
        propertyService.deleteProperty(id);
        return ServerResponse.success();
    }

    //修改数据
    @RequestMapping("updateProperty")
    public ServerResponse updateProperty(Property property){
        propertyService.updateProperty(property);
        return ServerResponse.success();
    }

    //批量删除
    @RequestMapping("deleteBathProperty")
    public ServerResponse deleteBathProperty(@RequestParam String[] ids){
        propertyService.deleteBathProperty(ids);
        return ServerResponse.success();
    }
}
