package com.fh.article.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    //ID
    private Integer articleId;
    //物品名称
    private String articleName;
    //物品单价
    private double articlePrice;
    //物品数量
    private Integer articleCount;
    //入库人
    private String storeMember;
    //入库时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date storeDate;
    //说明
    private String information;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articlePrice=" + articlePrice +
                ", articleCount=" + articleCount +
                ", storeMember='" + storeMember + '\'' +
                ", storeDate=" + storeDate +
                ", information='" + information + '\'' +
                '}';
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getStoreMember() {
        return storeMember;
    }

    public void setStoreMember(String storeMember) {
        this.storeMember = storeMember;
    }

    public Date getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Date storeDate) {
        this.storeDate = storeDate;
    }
}
