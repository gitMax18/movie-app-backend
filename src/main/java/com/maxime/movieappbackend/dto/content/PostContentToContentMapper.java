package com.maxime.movieappbackend.dto.content;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.model.ContentType;
import com.maxime.movieappbackend.repository.CategoryRepository;
import com.maxime.movieappbackend.model.Category;

@Service
public class PostContentToContentMapper implements Function<PostContentRequestDto, Content> {

    private CategoryRepository categoryRepository;

    public PostContentToContentMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Content apply(PostContentRequestDto contentDto) {
        Content content = new Content();
        content.setTitle(contentDto.getTitle());
        content.setReleaseYear(contentDto.getReleaseYear());
        content.setResume(contentDto.getResume());
        content.setShortResume(contentDto.getShortResume());
        content.type(ContentType.valueOf(contentDto.getType()));
        if (contentDto.getCategories() != null) {
            for (Long categoryId : contentDto.getCategories()) {
                Optional<Category> opCategory = categoryRepository.findById(categoryId);
                if (!opCategory.isPresent()) {
                    throw new RessourceNotFoundException("Category with id " + categoryId + " not found");
                }
                content.addCategory(opCategory.get());
            }
        }
        return content;
    }

}
