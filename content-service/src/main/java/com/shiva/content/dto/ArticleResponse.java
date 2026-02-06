package com.shiva.content.dto;


import java.time.LocalDate;
import java.util.List;

public class ArticleResponse {

    private String title;
    private String slug;
    private String description;
    private String content;
    private List<String> imageUrls;
    private String poojaDay;
    private LocalDate poojaDate;
    
    /* ================== Constructors ================== */

    public ArticleResponse() {
    }

    private ArticleResponse(Builder builder) {
        this.title = builder.title;
        this.slug = builder.slug;
        this.description = builder.description;
        this.content = builder.content;
        this.imageUrls = builder.imageUrls;
        this.poojaDay = builder.poojaDay;
        this.poojaDate = builder.poojaDate;
    }

    /* ================== Getters & Setters ================== */

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

    /* ================== Manual Builder ================== */

    public static class Builder {
        private String title;
        private String slug;
        private String description;
        private String content;
        private List<String> imageUrls;
        private String poojaDay;
        private LocalDate poojaDate;

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

        public ArticleResponse build() {
            return new ArticleResponse(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
