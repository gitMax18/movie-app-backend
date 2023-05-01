package com.maxime.movieappbackend.service.content;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.repository.ContentRepository;

@Service
public class ContentServiceImp implements ContentService {

    private ContentRepository contentRepository;

    public ContentServiceImp(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<Content> getAllContent() {
        List<Content> contents = contentRepository.findAll();
        contents.forEach(System.out::println);
        return contents;
    }

}
