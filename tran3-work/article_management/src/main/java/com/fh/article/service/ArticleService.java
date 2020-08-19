package com.fh.article.service;

import com.fh.article.common.ServerResponse;
import com.fh.article.model.Article;
import com.fh.article.param.Param;

import java.util.List;

public interface ArticleService {

    ServerResponse queryList(Param param);
}
