package com.fh.garage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.common.ServerResponse;
import com.fh.garage.model.Garage;
import com.fh.garage.param.GarageParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GarageMapper extends BaseMapper<Garage> {
    long selectCountt(GarageParam garageParam);

    List<Garage> queryList(GarageParam garageParam);

    void addGarage(Garage garage);

    void del(Integer xId);

    void deleteBatch(List list);

    void updateGarage(Garage garage);
}
