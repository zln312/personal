package com.zln.personal.service;

import com.zln.personal.entity.Article;
import com.zln.personal.page.PageRequest;
import com.zln.personal.page.PageResult;

import java.util.List;
public interface ArticleService {

    PageResult findAll(PageRequest pageRequest);

    Article getArticleById(long id);

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(long id);


}
