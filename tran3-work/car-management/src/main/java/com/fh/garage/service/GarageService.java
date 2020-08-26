package com.fh.garage.service;

import com.fh.common.ServerResponse;
import com.fh.garage.model.Garage;
import com.fh.garage.param.GarageParam;

import java.util.List;

public interface GarageService {
    long selectCount(GarageParam garageParam);

    List<Garage> queryList(GarageParam garageParam);

    void deleteBatch(List list);

    void updateGarage(Garage garage);

    void addGarage(Garage garage);

    void del(Integer xId);
}
