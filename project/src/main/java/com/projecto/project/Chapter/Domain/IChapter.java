package com.projecto.project.Chapter.Domain;

import java.util.Optional;

import java.util.List;






public interface IChapter {

    Optional <Chapter> findById(Long id); 
    // Page<Chapter> findAllForChapter(Pageable pageable);
    Chapter createOne (Chapter chapter);
    List<Chapter> findChaptersByIdSurvey(Long idSurvey);

    Optional<Chapter> update(Long id, Chapter chapter);
    Optional <Chapter> delete(Long id);
}

