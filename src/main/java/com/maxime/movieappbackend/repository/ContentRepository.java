package com.maxime.movieappbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maxime.movieappbackend.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    boolean existsByTitle(String title);

    List<Content> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT c.imagePath FROM Content c WHERE c.id = :id")
    String findImageNameById(@Param("id") Long id);

    @Query("SELECT COUNT(c) FROM Content c WHERE LOWER(c.title) = LOWER(:title) AND c.id != :id")
    int countByTitleIgnoreSameId(String title, Long id);
}
