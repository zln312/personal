package com.zln.personal.service;

import com.zln.personal.entity.Article;

import java.util.List;
public interface ArticleService {
    List<Article> getArtList();

    Article getArticleById(long id);

    Article getArticleByTag(int tag);

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(long id);


}
