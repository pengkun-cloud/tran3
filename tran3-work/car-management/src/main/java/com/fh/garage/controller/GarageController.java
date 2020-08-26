package com.fh.garage.controller;

import com.fh.common.ServerResponse;
import com.fh.garage.model.Garage;
import com.fh.garage.param.GarageParam;
import com.fh.garage.service.GarageService;
import com.fh.send.model.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("garages")
public class GarageController {

    @Autowired
    private GarageService garageService;

    @RequestMapping("queryList")
    public ServerResponse queryList(GarageParam garageParam){
        long totalCount =  garageService.selectCount(garageParam);
        List<Garage> list = garageService.queryList(garageParam);
        Map<String,Object> map =new HashMap();
        map.put("totalCount",totalCount);
        map.put("list",list);
        return ServerResponse.success(map);
    }

    @RequestMapping("addGarage")
    public ServerResponse addGarage(Garage garage){
        garageService.addGarage(garage);
        return ServerResponse.success();
    }

    @RequestMapping("del/{xId}")
    public ServerResponse del(@PathVariable("xId") Integer xId){
        garageService.del(xId);
        return ServerResponse.success();
    }

    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List list){
        garageService.deleteBatch(list);
        return ServerResponse.success();
    }

    @RequestMapping("updateGarage")
    public ServerResponse updateGarage(Garage garage){
        garageService.updateGarage(garage);
        return ServerResponse.success();
    }
}
