package com.fh.personnel.service;

import com.fh.common.ServerResponse;
import com.fh.personnel.mapper.PersonnelMapper;
import com.fh.personnel.medol.Personnel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Resource
    private PersonnelMapper personnelMapper;

    @Override
    public ServerResponse queryPersonnel() {
        Map mm=new HashMap();
        List<Personnel> list = personnelMapper.queryPersonnel();
        mm.put("data",list);
        return ServerResponse.scuess(list);
    }

    @Override
    public void updatePersonnel(Personnel personnel) {
        personnelMapper.updatePersonnel(personnel);
    }

    @Override
    public void addPersonnel(Personnel personnel) {
        personnelMapper.addPersonnel(personnel);
    }

    @Override
    public void delPersonnel(Integer id) {
        personnelMapper.delPersonnel(id);
    }

    @Override
    public Personnel getPersonnelByName(String name) {
        Personnel personnel = personnelMapper.getPersonnelByName(name);
        return personnel;
    }

    @Override
    public void updatePassword(Personnel personnel) {
        personnelMapper.updatePassword(personnel);
    }



}
