package com.maxime.movieappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxime.movieappbackend.dto.content.PostContentRequestDto;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.response.Response;
import com.maxime.movieappbackend.service.content.ContentService;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private ContentService contentService;

    public ContentController(@Qualifier("contentServiceImp") ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("")
    public Response<List<Content>> getAllContent() {
        return new Response<List<Content>>(HttpStatus.OK.value(), "Contents retrived", contentService.getAllContent());
    }

    @GetMapping("{id}")
    public Response<Content> getContentById(@PathVariable Long id) {
        return new Response<Content>(HttpStatus.OK.value(), "Content with id " + id + " retrived",
                contentService.getContentById(id));
    }

    @PostMapping("")
    public Response<Content> createContent(@RequestBody PostContentRequestDto contentDto) {
        Content newContent = contentService.createContent(contentDto);

        return new Response<Content>(HttpStatus.CREATED.value(), "Content created", newContent);
    }

}
