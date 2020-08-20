package com.fh.article.mapper;

import com.fh.article.model.Article;
import com.fh.article.param.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    List<Article> queryList(Param param);

    long queryTotalCount(Param param);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(Integer articleId);


}
