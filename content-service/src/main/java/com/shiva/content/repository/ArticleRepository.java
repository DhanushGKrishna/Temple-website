package com.shiva.content.repository;

import com.shiva.content.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findBySlugAndPublishedTrue(String slug);

    List<Article> findByShowInNavbarTrueAndPublishedTrue();

    Page<Article> findByPublishedTrue(Pageable pageable);
    
    Optional<Article> findById(Long id);
    
    boolean existsBySlug(String slug);
}
