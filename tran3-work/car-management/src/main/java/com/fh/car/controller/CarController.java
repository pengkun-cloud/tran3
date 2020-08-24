package com.fh.car.controller;

import com.fh.car.model.Car;
import com.fh.car.param.CarParam;
import com.fh.car.service.CarService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("queryList")
    public ServerResponse queryList(CarParam carParam){
        long totalCount =  carService.selectCount(carParam);
        List<Car> list = carService.queryList(carParam);
        Map<String,Object> map =new HashMap();
        map.put("totalCount",totalCount);
        map.put("list",list);
        return ServerResponse.success(map);
    }

    @RequestMapping("typeList")
    public ServerResponse typeList(){
        return carService.typeList();
    }

    @RequestMapping("addCar")
    public ServerResponse addCar(Car car){
        carService.addCar(car);
        return ServerResponse.success();
    }

    @RequestMapping("updateCar")
    public ServerResponse updateCar(Car car){
        return carService.updateCar(car);
    }


    @RequestMapping("deleteCar/{cId}")
    public ServerResponse deleteCar(@PathVariable("cId") Integer cId){
        return carService.deleteCar(cId);
    }


    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List list){
        return  carService.deleteBatch(list);

    }

}
