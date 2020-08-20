package com.fh.MarketManagement.mapper;

import com.fh.MarketManagement.model.Market;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper {
    List<Market> querymar();

    void addmar(Market mar);

    void updatemar(Market mar);

    void huixianmar(Integer marid);

    void deletemar(Integer marid);

    void deleteallmar(List id);
}
