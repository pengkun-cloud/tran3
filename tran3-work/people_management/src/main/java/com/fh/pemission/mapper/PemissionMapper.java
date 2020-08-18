package com.fh.pemission.mapper;

import com.fh.pemission.medol.Pemission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PemissionMapper {

    List queryPemission();

    void updatePemission(Pemission pemission);

    void addPemission(Pemission pemission);

    void delPemission(Integer id);
}
