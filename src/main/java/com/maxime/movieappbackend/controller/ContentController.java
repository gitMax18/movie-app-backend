package com.maxime.movieappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.service.content.ContentService;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private ContentService contentService;

    public ContentController(@Qualifier("contentServiceImp") ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("")
    public List<Content> getAllContent() {
        return contentService.getAllContent();
    }

    @GetMapping("{id}")
    public Content getContentById(@PathVariable Long id) {
        return contentService.getContentById(id);
    }
}
