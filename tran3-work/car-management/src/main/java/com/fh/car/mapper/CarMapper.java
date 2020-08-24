package com.fh.car.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.car.model.Car;
import com.fh.car.param.CarParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
    List<Car> queryList(CarParam carParam);

    long selectCountt(CarParam carParam);

    void addCar(Car car);

    void deleteCar(Integer cId);

    void deleteBatch(List list);

    void updateCar(Car car);
}
