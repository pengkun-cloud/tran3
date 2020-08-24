package com.fh.send.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.send.model.Send;
import com.fh.send.param.SendParam;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SendMapper extends BaseMapper<Send> {
    List<Send> queryList(SendParam sendParam);

    long selectCountt(SendParam sendParam);

    void addSendCar(Send send);

    void delSend(Integer sId);

    void deleteBatch(List list);

    void updateSend(Send send);
}
