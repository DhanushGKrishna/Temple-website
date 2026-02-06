package com.shiva.content.dto;

import com.shiva.content.entity.ArticleCategory;

import java.time.LocalDate;
import java.util.List;


public class ArticleRequest {

    private String title;
    private String description;
    private String content;
    private List<String> imageUrls;
    private String poojaDay;
    private LocalDate poojaDate;
    private ArticleCategory category;
    private boolean showInNavbar;
    private boolean published;
    
    /* ================== Getters & Setters ================== */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
