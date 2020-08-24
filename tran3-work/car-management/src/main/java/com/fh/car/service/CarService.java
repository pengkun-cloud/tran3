package com.fh.car.service;

import com.fh.car.model.Car;
import com.fh.car.param.CarParam;
import com.fh.common.ServerResponse;

import java.util.List;

public interface CarService {
    long selectCount(CarParam carParam);

    List<Car> queryList(CarParam carParam);

    ServerResponse typeList();

    void addCar(Car car);

    ServerResponse deleteCar(Integer cId);

    ServerResponse deleteBatch(List list);

    ServerResponse updateCar(Car car);
}
