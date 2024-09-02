package com.projecto.project.Chapter.Domain;

import java.util.Optional;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IChapter {

    Optional <Chapter> findById(Long id); 
    // Page<Chapter> findAllForChapter(Pageable pageable);
    Chapter createOne (Chapter chapter);
    List<Chapter> findChaptersByIdSurvey(Long idSurvey);
}
