package com.fh.MarketManagement.service;


import com.fh.MarketManagement.mapper.MarketMapper;
import com.fh.MarketManagement.model.Market;
import com.fh.commom.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MarketServiceImpl implements MarketService{

    @Resource
    private MarketMapper marketmapper;

    @Transactional
    @Override
    public ServerResponse querymar() {
        ServerResponse serverresponse=null;
        try {
            List<Market> marlist= marketmapper.querymar();
            serverresponse=ServerResponse.success(marlist);
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }

    }

    @Transactional
    @Override
    public ServerResponse addmar(Market mar) {
        ServerResponse serverresponse=null;
        try {
           marketmapper.addmar(mar);
            serverresponse=ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse updatemar(Market mar) {
        ServerResponse serverresponse=null;
        try {
            marketmapper.updatemar(mar);
            serverresponse=ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse huixianmar(Integer marid) {
        ServerResponse serverresponse=null;
        try {
            marketmapper.huixianmar(marid);
            serverresponse=ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse deletemar(Integer marid) {
        ServerResponse serverresponse=null;
        try {
            marketmapper.deletemar(marid);
            serverresponse=ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }
    }
    @Transactional
    @Override
    public ServerResponse deleteallmar(List id) {
        ServerResponse serverresponse=null;
        try {
            marketmapper.deleteallmar(id);
            serverresponse=ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse=ServerResponse.error(e);
        } finally {
            return serverresponse;
        }
    }
}
