package com.maxime.movieappbackend.dto.content;

import java.util.List;

import com.maxime.movieappbackend.model.Category;
import com.maxime.movieappbackend.model.ContentType;

public class ContentResponseDto {
    private Long id;
    private String title;
    private String resume;
    private String shortResume;
    private Integer releaseYear;
    private ContentType type;
    private String imagePath;
    private Long userId;
    List<Category> categories;

    public ContentResponseDto() {
    }

    public ContentResponseDto(Long id, String title, String resume, String shortResume, Integer releaseYear,
            ContentType type, String imagePath, Long userId, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.shortResume = shortResume;
        this.releaseYear = releaseYear;
        this.type = type;
        this.imagePath = imagePath;
        this.userId = userId;
        this.categories = categories;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getShortResume() {
        return this.shortResume;
    }

    public void setShortResume(String shortResume) {
        this.shortResume = shortResume;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ContentType getType() {
        return this.type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ContentResponseDto id(Long id) {
        setId(id);
        return this;
    }

    public ContentResponseDto title(String title) {
        setTitle(title);
        return this;
    }

    public ContentResponseDto resume(String resume) {
        setResume(resume);
        return this;
    }

    public ContentResponseDto shortResume(String shortResume) {
        setShortResume(shortResume);
        return this;
    }

    public ContentResponseDto releaseYear(Integer releaseYear) {
        setReleaseYear(releaseYear);
        return this;
    }

    public ContentResponseDto type(ContentType type) {
        setType(type);
        return this;
    }

    public ContentResponseDto imagePath(String imagePath) {
        setImagePath(imagePath);
        return this;
    }

    public ContentResponseDto userId(Long userId) {
        setUserId(userId);
        return this;
    }

    public ContentResponseDto categories(List<Category> categories) {
        setCategories(categories);
        return this;
    }

}
