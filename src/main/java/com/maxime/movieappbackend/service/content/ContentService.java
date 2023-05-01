package com.maxime.movieappbackend.service.content;

import java.util.List;

import com.maxime.movieappbackend.model.Content;

public interface ContentService {
    List<Content> getAllContent();

    Content getContentById(Long id);
}
