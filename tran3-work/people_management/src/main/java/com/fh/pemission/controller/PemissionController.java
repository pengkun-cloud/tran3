package com.fh.pemission.controller;

import com.fh.common.ServerResponse;
import com.fh.pemission.medol.Pemission;
import com.fh.pemission.service.PemissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pemission")
@CrossOrigin
public class PemissionController {

    @Autowired
    private PemissionService pemissionService;

    @RequestMapping("queryPemission")
    public ServerResponse queryPemission(){
        return pemissionService.queryPemission();
    }

    @RequestMapping("addOrUpdate")
    public ServerResponse addOrUpdate(Pemission pemission){
        if(pemission.getId()!=null){
            pemissionService.updatePemission(pemission);
        }else{
            pemissionService.addPemission(pemission);
        }
        return ServerResponse.scuess();
    }
    @RequestMapping("delPemission")
    public ServerResponse delPemission(Integer id){
        pemissionService.delPemission(id);
        return ServerResponse.scuess();
    }

}
