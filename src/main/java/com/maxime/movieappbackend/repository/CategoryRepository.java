package com.maxime.movieappbackend.repository;

import org.springframework.stereotype.Repository;

import com.maxime.movieappbackend.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
