package com.projecto.project.Chapter.Domain;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IChapter {

    Optional <Chapter> findById(Long id); 
    Page<Chapter> findAll(Pageable pageable);
}
