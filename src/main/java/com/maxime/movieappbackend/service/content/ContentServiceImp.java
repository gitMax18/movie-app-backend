package com.maxime.movieappbackend.service.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.Exception.exceptionTypes.UniqueConstraintException;
import com.maxime.movieappbackend.dto.content.PostContentRequestDto;
import com.maxime.movieappbackend.dto.content.PostContentToContentMapper;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.repository.CategoryRepository;
import com.maxime.movieappbackend.repository.ContentRepository;

@Service
public class ContentServiceImp implements ContentService {

    private ContentRepository contentRepository;
    private PostContentToContentMapper postContentToContentMapper;

    public ContentServiceImp(ContentRepository contentRepository, CategoryRepository categoryRepository,
            PostContentToContentMapper postContentToContentMapper) {
        this.contentRepository = contentRepository;
        this.postContentToContentMapper = postContentToContentMapper;

    }

    @Override
    public List<Content> getAllContent() {
        List<Content> contents = contentRepository.findAll();
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

    @Override
    public Content createContent(PostContentRequestDto contentDto) {
        if (contentRepository.existsByTitle(contentDto.getTitle())) {
            Map<String, String> details = new HashMap<>();
            details.put("title", contentDto.getTitle() + " already exist, title must be unique");
            throw new UniqueConstraintException("Constraint violation", details);
        }
        Content content = postContentToContentMapper.apply(contentDto);
        return contentRepository.save(content);
    }

    @Override
    public void deleteContentById(Long id) {
        Optional<Content> opContent = contentRepository.findById(id);
        if (!opContent.isPresent()) {
            throw new RessourceNotFoundException("Content with id " + id + " not found");
        }

        contentRepository.deleteById(id);
    }

    @Override
    public Content updateContent(Long id, PostContentRequestDto contentDto) {
        if (contentRepository.existsByTitle(contentDto.getTitle())) {
            Map<String, String> details = new HashMap<>();
            details.put("title", contentDto.getTitle() + " already exist, title must be unique");
            throw new UniqueConstraintException("Constraint violation", details);
        }
        Content content = postContentToContentMapper.apply(contentDto);
        content.setId(id);
        return contentRepository.save(content);
    }

}
