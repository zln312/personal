package com.zln.personal.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zln.personal.entity.Article;
import com.zln.personal.mapper.ArticleMapper;
import com.zln.personal.page.PageRequest;
import com.zln.personal.page.PageResult;
import com.zln.personal.page.PageUtils;
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
    public PageResult findAll(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Article> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.findAll();
        return new PageInfo<Article>(articles);
    }


    @Override
    public Article getArticleById(long id) {
        return articleMapper.findArticleById(id);
    }


    @Override
    public int addArticle(Article article) {
        long time = System.currentTimeMillis();
        article.setCreateTime(time);
        article.setUpdateTime(time);
        return articleMapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        long time = System.currentTimeMillis();
        article.setUpdateTime(time);
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(long id) {
        return articleMapper.deleteArticle(id);
    }

}
