package com.fh.pemission.service;

import com.fh.common.ServerResponse;
import com.fh.pemission.medol.Pemission;

public interface PemissionService {
    ServerResponse queryPemission();

    void updatePemission(Pemission pemission);

    void addPemission(Pemission pemission);

    void delPemission(Integer id);
}
