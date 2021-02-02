package com.zln.personal.service;

import com.zln.personal.entity.Article;
import com.zln.personal.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ArticleServiceImpl implements ArticleService{
    private ArticleMapper articleMapper;
    @Autowired
    public void setArticleMapper(ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
    }
    @Override
    public List<Article> getArtList() {
        return articleMapper.findAll();
    }

    @Override
    public Article getArticleById(long id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public Article getArticleByTag(int tag) {
        return articleMapper.findArticleByTag(tag);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(long id) {
        return articleMapper.deleteArticle(id);
    }

}
