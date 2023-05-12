package com.maxime.movieappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maxime.movieappbackend.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    boolean existsByTitle(String title);

    @Query("SELECT c.imagePath FROM Content c WHERE c.id = :id")
    String findImageNameById(@Param("id") Long id);
}
