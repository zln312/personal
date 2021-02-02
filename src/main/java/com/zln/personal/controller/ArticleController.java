package com.zln.personal.controller;

import com.zln.personal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.zln.personal.entity.Article;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/list")
    public List<Article> getList() {
        return articleService.getArtList();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable long id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/tag/{tag}")
    public Article getArticleByTag(@PathVariable int tag) {
        return articleService.getArticleByTag(tag);
    }

    @PostMapping
    public int addArticle( @RequestBody @Validated Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping
    public int updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    public int deleteArticle(@PathVariable long id) {
        return articleService.deleteArticle(id);
    }

}
