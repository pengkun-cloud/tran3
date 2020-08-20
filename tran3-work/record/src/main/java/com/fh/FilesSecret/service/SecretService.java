package com.fh.FilesSecret.service;

import com.fh.FilesSecret.model.Secret;
import com.fh.commom.ServerResponse;

public interface SecretService {
    ServerResponse querysecret();

    ServerResponse addsecret(Secret sec);

    ServerResponse updatesecret(Secret sec);

    ServerResponse deletsecret(Integer secid);

    ServerResponse huixiansecret(Integer secid);
}
