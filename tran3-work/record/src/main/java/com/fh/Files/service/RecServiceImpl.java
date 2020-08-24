package com.fh.Files.service;

import com.fh.Files.mapper.RecMapper;
import com.fh.Files.model.Record;
import com.fh.Files.vo.RecordVo;
import com.fh.commom.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecServiceImpl implements RecService {

    @Resource
    private RecMapper recmapper;

    @Transactional
    @Override
    public ServerResponse queryrecord() {

        List<RecordVo> recvolist= recmapper.queryrecord();

        return ServerResponse.success(recvolist);
    }

    @Transactional
    @Override
    public ServerResponse addrecord(Record rec) {
        ServerResponse serverresponse =null;
        try {
            recmapper.addrecord(rec);
             serverresponse = ServerResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse updateecord(Record rec) {
        ServerResponse serverresponse =null;
        try {
            recmapper.updateecord(rec);
            serverresponse = ServerResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse deleteecord(Integer recid) {
        ServerResponse serverresponse =null;
        try {
            recmapper.deleteecord(recid);
            serverresponse = ServerResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse deleteallecord(List id) {
        ServerResponse serverresponse =null;
        try {
            recmapper.deleteallecord(id);
            serverresponse = ServerResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse huixianecord(Integer recid) {
        ServerResponse serverresponse =null;
        try {
            RecordVo recredvo=recmapper.huixianecord(recid);
            serverresponse = ServerResponse.success(recredvo);
        }catch (Exception e){
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }
}
