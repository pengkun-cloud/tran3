package com.fh.send.controller;

import com.fh.common.ServerResponse;
import com.fh.send.model.Send;
import com.fh.send.param.SendParam;
import com.fh.send.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("sends")
public class SendController {

    @Autowired
    private SendService sendService;

    @RequestMapping("queryList")
    public ServerResponse queryList(SendParam sendParam){
        long totalCount =  sendService.selectCount(sendParam);
        List<Send> list = sendService.queryList(sendParam);
        Map<String,Object> map =new HashMap();
        map.put("totalCount",totalCount);
        map.put("list",list);
        return ServerResponse.success(map);
    }

    @RequestMapping("querySendCar")
    public ServerResponse querySendCar(){
        return sendService.querySendCar();
    }

    @RequestMapping("addSendCar")
    public ServerResponse addSendCar(Send send){
        return sendService.addSendCar(send);
    }

    @RequestMapping("delSend/{sId}")
    public ServerResponse delSend(@PathVariable("sId") Integer sId){
        return sendService.delSend(sId);
    }

    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List list){
        return sendService.deleteBatch(list);
    }

    @RequestMapping("updateSend")
    public ServerResponse updateSend(Send send){
        return sendService.updateSend(send);
    }
}
