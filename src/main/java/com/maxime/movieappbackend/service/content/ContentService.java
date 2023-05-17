package com.maxime.movieappbackend.service.content;

import java.util.List;

import com.maxime.movieappbackend.dto.content.ContentResponseDto;
import com.maxime.movieappbackend.dto.content.PostContentRequestDto;

public interface ContentService {
    List<ContentResponseDto> getAllContent();

    ContentResponseDto getContentById(Long id);

    ContentResponseDto createContent(PostContentRequestDto contentDto);

    void deleteContentById(Long id);

    ContentResponseDto updateContent(Long id, PostContentRequestDto contentDto);
}
