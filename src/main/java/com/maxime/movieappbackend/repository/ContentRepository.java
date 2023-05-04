package com.maxime.movieappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxime.movieappbackend.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    boolean existsByTitle(String title);
}
