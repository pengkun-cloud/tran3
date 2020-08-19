package com.fh.article.service;

import com.fh.article.common.ServerResponse;
import com.fh.article.mapper.ArticleMapper;
import com.fh.article.model.Article;
import com.fh.article.param.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public ServerResponse queryList(Param param) {
        Map<String, Object> map = new HashMap<>();
        long totalCount = articleMapper.queryTotalCount(param);
        List<Article> list = articleMapper.queryList(param);
        map.put("totalCount", totalCount);
        map.put("list", list);
        return ServerResponse.success(map);
    }
}
