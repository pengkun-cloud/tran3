package com.fh.personnel.controller;

import com.fh.common.ServerResponse;
import com.fh.personnel.medol.Personnel;
import com.fh.personnel.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personnel")
@CrossOrigin
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;


    @RequestMapping("queryPersonnel")
    public ServerResponse queryPersonnel(){
        return personnelService.queryPersonnel();
    }

    @RequestMapping("addOrUpdate")
    public ServerResponse addOrUpdate(Personnel personnel){
        if(personnel.getId()!=null){
            personnelService.updatePersonnel(personnel);
        }else{
            personnelService.addPersonnel(personnel);
        }
        return ServerResponse.scuess();
    }


    @RequestMapping("delPersonnel")
    public ServerResponse delPersonnel(Integer id){
        personnelService.delPersonnel(id);
        return ServerResponse.scuess();
    }
}
