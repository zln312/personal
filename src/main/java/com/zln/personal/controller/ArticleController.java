package com.zln.personal.controller;

import com.zln.personal.mapper.ArticleTagMapper;
import com.zln.personal.page.PageRequest;
import com.zln.personal.service.ArticleService;
import com.zln.personal.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zln.personal.entity.Article;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {

    private final ArticleTagService articleTagService;
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService, ArticleTagService articleTagService) {
        this.articleService = articleService;
        this.articleTagService = articleTagService;
    }

    @PostMapping("/list")
    public Object getList(@RequestBody  PageRequest pageRequest) {
            return articleService.findAll(pageRequest);
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        Article article = articleService.getArticleById(id);
        String oldIds = articleTagService.getTagIdsByArtId(article.getId());
        if(oldIds!=null){
            System.out.println(oldIds);
            List<Number> ids = new LinkedList<>();
            for(String s:Arrays.asList(oldIds.split(","))){
                ids.add(Integer.valueOf(s));
            }
            System.out.println(ids);
            article.setTagIds(ids);
        }

        return article;
    }


    @PostMapping
    public long addArticle( @RequestBody @Validated Article article) {
        articleService.addArticle(article);
        articleTagService.addArticleTag(article.getId(),article.getTagIds());
        return article.getId();
    }

    @PutMapping
    public int updateArticle(@RequestBody @Validated Article article) {
        List<Number> newIds = article.getTagIds();
        String oldIds = articleTagService.getTagIdsByArtId(article.getId());
        if(oldIds==null){
            oldIds="";
        }

        String newIdsString = newIds.toString();
        String subString = newIdsString.substring(1,newIdsString.length()-1);
        String result = subString.replaceAll("\\s","");

        if(oldIds.equals(result)){
            System.out.println("tagIds重复，不需要更新");
        }else {
            articleTagService.deleteArtTagByAid(article.getId());
            if(!newIds.isEmpty()){
                articleTagService.addArticleTag(article.getId(),article.getTagIds());
            }
        }
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    public int deleteArticle(@PathVariable long id) {
        return articleService.deleteArticle(id);
    }

}
