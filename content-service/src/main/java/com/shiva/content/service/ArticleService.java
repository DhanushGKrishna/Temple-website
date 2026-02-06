package com.shiva.content.service;

import com.shiva.content.dto.*;

import com.shiva.content.entity.Article;
import com.shiva.content.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // ---------------- ADMIN ----------------

    public Article createArticle(ArticleRequest request) {

        String slug = generateSlug(request.getTitle());

        if (articleRepository.existsBySlug(slug)) {
            throw new RuntimeException("Article with same title already exists");
        }

        Article article = Article.builder()
                .title(request.getTitle())
                .slug(slug)
                .description(request.getDescription())
                .content(request.getContent())
                .imageUrls(request.getImageUrls())
                .poojaDay(request.getPoojaDay())
                .poojaDate(request.getPoojaDate())
                .category(request.getCategory())
                .showInNavbar(request.isShowInNavbar())
                .published(request.isPublished())
                .build();

        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, ArticleRequest request) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        article.setTitle(request.getTitle());
        article.setSlug(generateSlug(request.getTitle()));
        article.setDescription(request.getDescription());
        article.setContent(request.getContent());
        article.setImageUrls(request.getImageUrls());
        article.setPoojaDay(request.getPoojaDay());
        article.setPoojaDate(request.getPoojaDate());
        article.setCategory(request.getCategory());
        article.setShowInNavbar(request.isShowInNavbar());
        article.setPublished(request.isPublished());

        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.delete(article);
    }

    public Page<Article> getAllArticlesForAdmin(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return articleRepository.findAll(pageable);
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    // ---------------- PUBLIC ----------------

    public ArticleResponse getArticleBySlug(String slug) {

        Article article = articleRepository.findBySlugAndPublishedTrue(slug)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        return ArticleResponse.builder()
                .title(article.getTitle())
                .slug(article.getSlug())
                .description(article.getDescription())
                .content(article.getContent())
                .imageUrls(article.getImageUrls())
                .poojaDay(article.getPoojaDay())
                .poojaDate(article.getPoojaDate())
                .build();
    }

    public List<Article> getNavbarArticles() {
        return articleRepository.findByShowInNavbarTrueAndPublishedTrue();
    }

    public Page<Article> getAllPublishedArticles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return articleRepository.findByPublishedTrue(pageable);
    }

    // ---------------- UTIL ----------------

    private String generateSlug(String title) {
        return title.toLowerCase()
                .replaceAll("[^a-z0-9]", "-")
                .replaceAll("-+", "-")
                .replaceAll("(^-|-$)", "");
    }
}
