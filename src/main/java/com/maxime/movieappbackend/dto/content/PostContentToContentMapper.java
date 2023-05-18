package com.maxime.movieappbackend.dto.content;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.model.Content;
import com.maxime.movieappbackend.model.ContentType;
import com.maxime.movieappbackend.model.User;
import com.maxime.movieappbackend.repository.CategoryRepository;
import com.maxime.movieappbackend.repository.UserRepository;
import com.maxime.movieappbackend.model.Category;

@Service
public class PostContentToContentMapper implements Function<PostContentRequestDto, Content> {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public PostContentToContentMapper(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Content apply(PostContentRequestDto contentDto) {
        Content content = new Content();
        if (contentDto.getId() != null) {
            content.setId(contentDto.getId());
        }
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
        Optional<User> opUser = userRepository.findById(contentDto.getUserId());
        if (!opUser.isPresent()) {
            throw new RessourceNotFoundException("User with id " + contentDto.getUserId() + " not found");
        }

        content.setUser(opUser.get());

        return content;
    }

}
