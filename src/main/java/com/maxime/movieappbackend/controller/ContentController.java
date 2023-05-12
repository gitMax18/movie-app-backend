package com.maxime.movieappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.NullNode;
import com.maxime.movieappbackend.dto.content.PostContentRequestDto;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.response.Response;
import com.maxime.movieappbackend.service.content.ContentService;
import com.maxime.movieappbackend.service.file.FileService;

import jakarta.validation.Valid;

@CrossOrigin(origins = { "${app.origin}" })
@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private ContentService contentService;
    private FileService fileService;

    public ContentController(@Qualifier("contentServiceImp") ContentService contentService,
            FileService fileService) {
        this.contentService = contentService;
        this.fileService = fileService;
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

    @PostMapping(value = "", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Response<Content> createContent(@Valid @ModelAttribute PostContentRequestDto contentDto) {
        Content newContent = contentService.createContent(contentDto);

        return new Response<Content>(HttpStatus.CREATED.value(), "Content created", newContent);
    }

    @DeleteMapping("/{id}")
    public Response<NullNode> deleteContentById(@PathVariable Long id) {
        contentService.deleteContentById(id);
        return new Response<NullNode>(HttpStatus.OK.value(), "Content deleted", null);
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Response<Content> updateContent(@PathVariable Long id,
            @Valid @ModelAttribute PostContentRequestDto contentDto) {
        Content updatedContent = contentService.updateContent(id, contentDto);

        return new Response<Content>(HttpStatus.OK.value(), "Content updated", updatedContent);
    }

    @GetMapping("/image/{fileName}")
    public ResponseEntity<Resource> getContentImage(@PathVariable String fileName) {
        Resource resource = fileService.downloadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
