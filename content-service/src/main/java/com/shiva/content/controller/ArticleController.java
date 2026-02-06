package com.shiva.content.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Page;
import java.util.List;

import com.shiva.content.service.ArticleService;
import com.shiva.content.entity.Article;
import com.shiva.content.dto.ArticleResponse;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;
    
    public ArticleController(ArticleService articleService) {
    	this.articleService = articleService;
    }

    @GetMapping("/navbar")
    public List<Article> getNavbarArticles() {
        return articleService.getNavbarArticles();
    }

    @GetMapping("/{slug}")
    public ArticleResponse getArticle(@PathVariable String slug) {
        return articleService.getArticleBySlug(slug);
    }

    @GetMapping
    public Page<Article> getArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size
    ) {
        return articleService.getAllPublishedArticles(page, size);
    }
}
