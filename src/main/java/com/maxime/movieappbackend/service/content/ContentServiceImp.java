package com.maxime.movieappbackend.service.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.Exception.exceptionTypes.UniqueConstraintException;
import com.maxime.movieappbackend.dto.content.ContentResponseDto;
import com.maxime.movieappbackend.dto.content.ContentToContentDtoResponseMapper;
import com.maxime.movieappbackend.dto.content.PostContentRequestDto;
import com.maxime.movieappbackend.dto.content.PostContentToContentMapper;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.repository.CategoryRepository;
import com.maxime.movieappbackend.repository.ContentRepository;
import com.maxime.movieappbackend.service.file.FileService;

@Service
public class ContentServiceImp implements ContentService {

    private ContentRepository contentRepository;
    private PostContentToContentMapper postContentToContentMapper;
    private FileService fileService;
    private ContentToContentDtoResponseMapper contentToContentDtoResponseMapper;

    public ContentServiceImp(ContentRepository contentRepository, CategoryRepository categoryRepository,
            PostContentToContentMapper postContentToContentMapper, FileService fileService,
            ContentToContentDtoResponseMapper contentToContentDtoResponseMapper) {
        this.contentRepository = contentRepository;
        this.postContentToContentMapper = postContentToContentMapper;
        this.fileService = fileService;
        this.contentToContentDtoResponseMapper = contentToContentDtoResponseMapper;

    }

    @Override
    public List<ContentResponseDto> getAllContent() {
        List<ContentResponseDto> contents = contentRepository.findAll().stream()
                .map(contentToContentDtoResponseMapper::apply).collect(Collectors.toList());
        return contents;
    }

    @Override
    public ContentResponseDto getContentById(Long id) {
        Optional<Content> opContent = contentRepository.findById(id);
        if (!opContent.isPresent()) {
            throw new RessourceNotFoundException("Content with id " + id + " not found");
        }
        return contentToContentDtoResponseMapper.apply(opContent.get());
    }

    @Override
    public ContentResponseDto createContent(PostContentRequestDto contentDto) {
        if (contentRepository.existsByTitle(contentDto.getTitle())) {
            Map<String, String> details = new HashMap<>();
            details.put("title", contentDto.getTitle() + " already exist, title must be unique");
            throw new UniqueConstraintException("Constraint violation", details);
        }
        String fileName = null;
        if (contentDto.getFile() instanceof MultipartFile) {
            fileName = fileService.uploadFile(contentDto.getFile());
        }
        Content content = postContentToContentMapper.apply(contentDto);
        content.setImagePath(fileName);
        Content savedContent = contentRepository.save(content);
        return contentToContentDtoResponseMapper.apply(savedContent);
    }

    @Override
    public void deleteContentById(Long id) {
        Optional<Content> opContent = contentRepository.findById(id);
        if (!opContent.isPresent()) {
            throw new RessourceNotFoundException("Content with id " + id + " not found");
        }
        String fileName = contentRepository.findImageNameById(id);
        if (fileName != null) {
            fileService.removeFile(fileName);
        }
        contentRepository.deleteById(id);
    }

    @Override
    public ContentResponseDto updateContent(Long id, PostContentRequestDto contentDto) {
        if (contentRepository.existsByTitle(contentDto.getTitle())) {
            Map<String, String> details = new HashMap<>();
            details.put("title", contentDto.getTitle() + " already exist, title must be unique");
            throw new UniqueConstraintException("Constraint violation", details);
        }
        String fileName = null;
        if (contentDto.getFile() instanceof MultipartFile) {
            fileName = fileService.uploadFile(contentDto.getFile());
            String oldFileName = contentRepository.findImageNameById(id);
            if (oldFileName != null) {
                fileService.removeFile(oldFileName);
            }
        }
        Content content = postContentToContentMapper.apply(contentDto);
        content.setImagePath(fileName);
        content.setId(id);
        Content updatedContent = contentRepository.save(content);
        return contentToContentDtoResponseMapper.apply(updatedContent);
    }
}
