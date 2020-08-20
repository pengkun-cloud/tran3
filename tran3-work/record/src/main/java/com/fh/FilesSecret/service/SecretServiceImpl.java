package com.fh.FilesSecret.service;

import com.fh.FilesSecret.mapper.SecretMapper;
import com.fh.FilesSecret.model.Secret;
import com.fh.commom.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecretServiceImpl implements SecretService{

    @Resource
    private SecretMapper secretmapper;

    @Transactional
    @Override
    public ServerResponse querysecret() {
        ServerResponse serverresponse=null;
        try {
            List<Secret> seclist=secretmapper.querysecret();
            serverresponse = ServerResponse.success(seclist);
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }

    }
    @Transactional
    @Override
    public ServerResponse addsecret(Secret sec) {
        ServerResponse serverresponse=null;
        try {
            secretmapper.addsecret(sec);
            serverresponse = ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse updatesecret(Secret sec) {
        ServerResponse serverresponse=null;
        try {
            secretmapper.updatesecret(sec);
            serverresponse = ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse deletsecret(Integer secid) {
        ServerResponse serverresponse=null;
        try {
            secretmapper.deletsecret(secid);
            serverresponse = ServerResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }

    @Transactional
    @Override
    public ServerResponse huixiansecret(Integer secid) {
        ServerResponse serverresponse=null;
        try {
            Secret secret=secretmapper.huixiansecret(secid);
            serverresponse = ServerResponse.success(secret);
        } catch (Exception e) {
            e.printStackTrace();
            serverresponse = ServerResponse.error(e);
        }finally {
            return serverresponse;
        }
    }
}
