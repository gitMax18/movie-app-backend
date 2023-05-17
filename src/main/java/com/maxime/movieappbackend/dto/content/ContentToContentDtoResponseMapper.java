package com.maxime.movieappbackend.dto.content;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.model.Content;

@Service
public class ContentToContentDtoResponseMapper implements Function<Content, ContentResponseDto> {

    @Override
    public ContentResponseDto apply(Content content) {
        ContentResponseDto contentDto = new ContentResponseDto();
        contentDto.setId(content.getId());
        contentDto.setTitle(content.getTitle());
        contentDto.setResume(content.getResume());
        contentDto.setShortResume(content.getShortResume());
        contentDto.setReleaseYear(content.getReleaseYear());
        contentDto.setType(content.getType());
        contentDto.setImagePath(content.getImagePath());
        contentDto.setUserId(content.getUser().getId());
        contentDto.setCategories(content.getCategories());
        return contentDto;
    }

}
