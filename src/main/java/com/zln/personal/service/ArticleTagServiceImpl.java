package com.zln.personal.service;

import com.zln.personal.mapper.ArticleTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleTagServiceImpl implements ArticleTagService{

    private ArticleTagMapper articleTagMapper;
    @Autowired
    public void getArticleTagMapper(ArticleTagMapper articleTagMapper){
        this.articleTagMapper = articleTagMapper;
    }
    @Override
    public int addArticleTag(long articleId, List<Number> tagIds) {
        return articleTagMapper.addArticleTag(articleId,tagIds);
    }

    @Override
    public String getTagIdsByArtId(long articleId) {
        return articleTagMapper.getTagIdsByArtId(articleId);
    }

    @Override
    public int deleteArtTagByAid(long articleId) {
        return articleTagMapper.deleteArticleTagByArtId(articleId);
    }
}
