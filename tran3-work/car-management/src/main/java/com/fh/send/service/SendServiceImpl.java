package com.fh.send.service;

import com.fh.car.mapper.CarMapper;
import com.fh.car.model.Car;
import com.fh.common.ServerResponse;
import com.fh.send.mapper.SendMapper;
import com.fh.send.model.Send;
import com.fh.send.param.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private SendMapper sendMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Send> queryList(SendParam sendParam) {
        return sendMapper.queryList(sendParam);
    }

    @Override
    public long selectCount(SendParam sendParam) {
        return sendMapper.selectCountt(sendParam);
    }

    @Override
    public ServerResponse addSendCar(Send send) {
        sendMapper.addSendCar(send);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse querySendCar() {
        List<Car> list = carMapper.selectList(null);
        return ServerResponse.success(list);
    }

    @Override
    public ServerResponse delSend(Integer sId) {
        sendMapper.delSend(sId);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBatch(List list) {
        sendMapper.deleteBatch(list);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateSend(Send send) {
        sendMapper.updateSend(send);
        return ServerResponse.success();
    }
}
