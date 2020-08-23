package com.fh.personnel.service;

import com.fh.common.ServerResponse;
import com.fh.personnel.medol.Personnel;

public interface PersonnelService {
    ServerResponse queryPersonnel();

    void updatePersonnel(Personnel personnel);

    void addPersonnel(Personnel personnel);

    void delPersonnel(Integer id);

    Personnel getPersonnelByName(String name);

    void updatePassword(Personnel personnel);
}
