package com.fh.garage.service;

import com.fh.common.ServerResponse;
import com.fh.garage.mapper.GarageMapper;
import com.fh.garage.model.Garage;
import com.fh.garage.param.GarageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    private GarageMapper garageMapper;

    @Override
    public long selectCount(GarageParam garageParam) {
        return garageMapper.selectCountt(garageParam);
    }

    @Override
    public List<Garage> queryList(GarageParam garageParam) {
        return garageMapper.queryList(garageParam);
    }

    @Override
    public void addGarage(Garage garage) {
        garageMapper.addGarage(garage);
    }

    @Override
    public void del(Integer xId) {
       garageMapper.del(xId);
    }


    @Override
    public void deleteBatch(List list) {
        garageMapper.deleteBatch(list);
    }

    @Override
    public void updateGarage(Garage garage) {
        garageMapper.updateGarage(garage);
    }
}
