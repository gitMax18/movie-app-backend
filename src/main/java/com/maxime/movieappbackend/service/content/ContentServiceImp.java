package com.maxime.movieappbackend.service.content;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
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

    @Override
    public Content getContentById(Long id) {
        Optional<Content> opContent = contentRepository.findById(id);
        if (!opContent.isPresent()) {
            throw new RessourceNotFoundException("Content with id " + id + " not found");
        }

        return opContent.get();
    }

}
