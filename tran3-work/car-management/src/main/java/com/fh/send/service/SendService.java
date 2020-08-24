package com.fh.send.service;

import com.fh.common.ServerResponse;
import com.fh.send.model.Send;
import com.fh.send.param.SendParam;

import java.util.List;

public interface SendService {
    List<Send> queryList(SendParam sendParam);

    long selectCount(SendParam sendParam);

    ServerResponse addSendCar(Send send);

    ServerResponse querySendCar();

    ServerResponse delSend(Integer sId);

    ServerResponse deleteBatch(List list);

    ServerResponse updateSend(Send send);
}
