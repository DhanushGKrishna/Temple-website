package com.shiva.content.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.data.domain.Page;

import lombok.RequiredArgsConstructor;

import com.shiva.content.service.ArticleService;
import com.shiva.content.entity.Article;
import com.shiva.content.dto.ArticleRequest;

@RestController
@RequestMapping("/api/admin/articles")
@RequiredArgsConstructor
public class AdminArticleController {
	
	
    private final ArticleService articleService;
    
    public AdminArticleController(ArticleService articleService) {
    	this.articleService = articleService;
    }

    // ✅ CREATE
    @PostMapping
    public Article createArticle(@RequestBody ArticleRequest request) {
        return articleService.createArticle(request);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Article updateArticle(
            @PathVariable Long id,
            @RequestBody ArticleRequest request
    ) {
        return articleService.updateArticle(id, request);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    // ✅ GET ALL (ADMIN VIEW)
    @GetMapping
    public Page<Article> getAllArticles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return articleService.getAllArticlesForAdmin(page, size);
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }
}
