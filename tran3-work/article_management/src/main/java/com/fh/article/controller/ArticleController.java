package com.fh.article.controller;

import com.fh.article.common.ServerResponse;
import com.fh.article.model.Article;
import com.fh.article.param.Param;
import com.fh.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("queryList")
    public ServerResponse queryList(Param param){
        return articleService.queryList(param);
    }

}
