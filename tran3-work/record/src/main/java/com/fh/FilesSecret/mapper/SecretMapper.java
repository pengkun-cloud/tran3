package com.fh.FilesSecret.mapper;

import com.fh.FilesSecret.model.Secret;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecretMapper {
    List<Secret> querysecret();

    void addsecret(Secret sec);

    void updatesecret(Secret sec);

    void deletsecret(Integer secid);

    Secret huixiansecret(Integer secid);
}
