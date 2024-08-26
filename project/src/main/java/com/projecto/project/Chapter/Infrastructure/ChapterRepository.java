package com.projecto.project.Chapter.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Chapter.Domain.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    
} 
