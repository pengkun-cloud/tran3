package com.fh.MarketManagement.service;

import com.fh.MarketManagement.model.Market;
import com.fh.commom.ServerResponse;

import java.util.List;

public interface MarketService {
    ServerResponse querymar();

    ServerResponse addmar(Market mar);

    ServerResponse updatemar(Market mar);

    ServerResponse huixianmar(Integer marid);

    ServerResponse deletemar(Integer marid);

    ServerResponse deleteallmar(List id);
}
