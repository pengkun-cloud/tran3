package com.fh.car.service;

import com.fh.car.mapper.CarMapper;
import com.fh.car.mapper.TypeMapper;
import com.fh.car.model.Car;
import com.fh.car.model.Type;
import com.fh.car.param.CarParam;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Car> queryList(CarParam carParam) {
        return carMapper.queryList(carParam);
    }

    @Override
    public ServerResponse typeList() {
        List<Type> list = typeMapper.selectList(null);
        return ServerResponse.success(list);
    }

    @Override
    public void addCar(Car car) {
        carMapper.addCar(car);
    }

    @Override
    public ServerResponse deleteCar(Integer cId) {
        carMapper.deleteCar(cId);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBatch(List list) {
        carMapper.deleteBatch(list);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateCar(Car car) {
        carMapper.updateCar(car);
        return ServerResponse.success();
    }

    @Override
    public long selectCount(CarParam carParam) {
        return carMapper.selectCountt(carParam);
    }


}
