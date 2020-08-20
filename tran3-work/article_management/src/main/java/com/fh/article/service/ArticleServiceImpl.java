package com.fh.article.service;

import com.fh.article.common.ServerResponse;
import com.fh.article.mapper.ArticleMapper;
import com.fh.article.model.Article;
import com.fh.article.param.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //分页查询办公用品
    @Override
    public ServerResponse queryList(Param param) {
        Map<String, Object> map = new HashMap<>();
        long totalCount = articleMapper.queryTotalCount(param);
        List<Article> list = articleMapper.queryList(param);
        map.put("totalCount", totalCount);
        map.put("list", list);
        return ServerResponse.success(map);
    }

    //物品入库
    @Transactional
    @Override
    public ServerResponse addArticle(Article article) {

        articleMapper.addArticle(article);
        return ServerResponse.success();
    }
  //修改信息
    @Transactional
    @Override
    public ServerResponse updateArticle(Article article) {

        articleMapper.updateArticle(article);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteArticle(Integer articleId) {
        articleMapper.deleteArticle(articleId);
        return ServerResponse.success();
    }


}
