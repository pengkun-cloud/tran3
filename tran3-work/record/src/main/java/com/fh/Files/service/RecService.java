package com.fh.Files.service;

import com.fh.Files.model.Record;
import com.fh.commom.ServerResponse;

import java.util.List;
import java.util.Map;

public interface RecService {
    ServerResponse queryrecord();

    ServerResponse addrecord(Record rec);

    ServerResponse updateecord(Record rec);

    ServerResponse deleteecord(Integer recid);

    ServerResponse deleteallecord(List id);

    ServerResponse huixianecord(Integer recid);
}
