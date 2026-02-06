package com.shiva.content.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;                 // Shivaratri

    @Column(nullable = false, unique = true)
    private String slug;                  // shivaratri

    @Column(columnDefinition = "LONGTEXT")
    private String description;           // 5k+ words summary

    @Column(columnDefinition = "LONGTEXT")
    private String content;               // 10k+ words full content

    @ElementCollection
    @CollectionTable(
        name = "article_images",
        joinColumns = @JoinColumn(name = "article_id")
    )
    @Column(name = "image_url", length = 500)
    private List<String> imageUrls;        // 2–4 images

    private String poojaDay;               // Wednesday

    private LocalDate poojaDate;           // 2026-02-26

    @Enumerated(EnumType.STRING)
    private ArticleCategory category;      // POOJA

    private boolean showInNavbar;           // true

    private boolean published;              // true

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    
    /* ================== Constructors ================== */

    public Article() {
    }

    private Article(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.slug = builder.slug;
        this.description = builder.description;
        this.content = builder.content;
        this.imageUrls = builder.imageUrls;
        this.poojaDay = builder.poojaDay;
        this.poojaDate = builder.poojaDate;
        this.category = builder.category;
        this.showInNavbar = builder.showInNavbar;
        this.published = builder.published;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }
    
    /* ================== Lifecycle Hooks ================== */

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    /* ================== Getters & Setters ================== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getPoojaDay() {
        return poojaDay;
    }

    public void setPoojaDay(String poojaDay) {
        this.poojaDay = poojaDay;
    }

    public LocalDate getPoojaDate() {
        return poojaDate;
    }

    public void setPoojaDate(LocalDate poojaDate) {
        this.poojaDate = poojaDate;
    }

    public ArticleCategory getCategory() {
        return category;
    }

    public void setCategory(ArticleCategory category) {
        this.category = category;
    }

    public boolean isShowInNavbar() {
        return showInNavbar;
    }

    public void setShowInNavbar(boolean showInNavbar) {
        this.showInNavbar = showInNavbar;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /* ================== Manual Builder ================== */

    public static class Builder {
        private Long id;
        private String title;
        private String slug;
        private String description;
        private String content;
        private List<String> imageUrls;
        private String poojaDay;
        private LocalDate poojaDate;
        private ArticleCategory category;
        private boolean showInNavbar;
        private boolean published;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder imageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
            return this;
        }

        public Builder poojaDay(String poojaDay) {
            this.poojaDay = poojaDay;
            return this;
        }

        public Builder poojaDate(LocalDate poojaDate) {
            this.poojaDate = poojaDate;
            return this;
        }

        public Builder category(ArticleCategory category) {
            this.category = category;
            return this;
        }

        public Builder showInNavbar(boolean showInNavbar) {
            this.showInNavbar = showInNavbar;
            return this;
        }

        public Builder published(boolean published) {
            this.published = published;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
