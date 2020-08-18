package com.fh.personnel.mapper;

import com.fh.personnel.medol.Personnel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelMapper {

    List<Personnel> queryPersonnel();

    void updatePersonnel(Personnel personnel);

    void addPersonnel(Personnel personnel);

    void delPersonnel(Integer id);
}
