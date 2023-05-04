package com.maxime.movieappbackend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String resume;
    @Column(name = "short_resume")
    private String shortResume;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private ContentType type;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "content_category", joinColumns = @JoinColumn(name = "content_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories = new ArrayList<>();

    public Content() {
    }

    public Content(String title, String resume, String shortResume, Integer releaseYear, ContentType type,
            List<Category> categories) {
        this.title = title;
        this.resume = resume;
        this.shortResume = shortResume;
        this.releaseYear = releaseYear;
        this.type = type;
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
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

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Content id(Long id) {
        setId(id);
        return this;
    }

    public Content title(String title) {
        setTitle(title);
        return this;
    }

    public Content resume(String resume) {
        setResume(resume);
        return this;
    }

    public Content shortResume(String shortResume) {
        setShortResume(shortResume);
        return this;
    }

    public Content releaseYear(Integer releaseYear) {
        setReleaseYear(releaseYear);
        return this;
    }

    public Content type(ContentType type) {
        setType(type);
        return this;
    }

    public Content categories(List<Category> categories) {
        setCategories(categories);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", resume='" + getResume() + "'" +
                ", shortResume='" + getShortResume() + "'" +
                ", releaseYear='" + getReleaseYear() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }

}
