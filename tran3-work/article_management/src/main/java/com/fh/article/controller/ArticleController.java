package com.fh.article.controller;

import com.fh.article.common.ServerResponse;
import com.fh.article.model.Article;
import com.fh.article.param.Param;
import com.fh.article.service.ArticleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("addArticle")
    public ServerResponse addArticle(Article article){

        return articleService.addArticle(article);
    }

    @RequestMapping("updateArticle")
    public ServerResponse updateArticle(Article article){
        return articleService.updateArticle(article);
    }

    @RequestMapping("deleteArticle/{articleId}")
    public ServerResponse deleteArticle(@PathVariable("articleId")Integer articleId){

        return articleService.deleteArticle(articleId);
    }


}
