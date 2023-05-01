package com.maxime.movieappbackend.dto.content;

import java.util.ArrayList;
import java.util.List;

import com.maxime.movieappbackend.model.ContentType;

public class PostContentRequestDto {
    private String title;
    private String resume;
    private String shortResume;
    private Integer releaseYear;
    private ContentType type;
    List<Long> categories = new ArrayList<>();

    public PostContentRequestDto() {
    }

    public PostContentRequestDto(String title, String resume, String shortResume, Integer releaseYear, ContentType type,
            List<Long> categories) {
        this.title = title;
        this.resume = resume;
        this.shortResume = shortResume;
        this.releaseYear = releaseYear;
        this.type = type;
        this.categories = categories;
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

    public List<Long> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public PostContentRequestDto title(String title) {
        setTitle(title);
        return this;
    }

    public PostContentRequestDto resume(String resume) {
        setResume(resume);
        return this;
    }

    public PostContentRequestDto shortResume(String shortResume) {
        setShortResume(shortResume);
        return this;
    }

    public PostContentRequestDto releaseYear(Integer releaseYear) {
        setReleaseYear(releaseYear);
        return this;
    }

    public PostContentRequestDto type(ContentType type) {
        setType(type);
        return this;
    }

    public PostContentRequestDto categories(List<Long> categories) {
        setCategories(categories);
        return this;
    }

}
