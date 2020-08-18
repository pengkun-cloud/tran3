package com.fh.pemission.service;

import com.fh.common.ServerResponse;
import com.fh.pemission.mapper.PemissionMapper;
import com.fh.pemission.medol.Pemission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PemissionServiceImpl implements PemissionService {

    @Resource
    private PemissionMapper pemissionMapper;

    @Override
    public ServerResponse queryPemission() {
        List list = pemissionMapper.queryPemission();
        return ServerResponse.scuess(list);
    }

    @Override
    public void updatePemission(Pemission pemission) {
        pemissionMapper.updatePemission(pemission);
    }

    @Override
    public void addPemission(Pemission pemission) {
        pemissionMapper.addPemission(pemission);
    }

    @Override
    public void delPemission(Integer id) {
        pemissionMapper.delPemission(id);
    }
}
