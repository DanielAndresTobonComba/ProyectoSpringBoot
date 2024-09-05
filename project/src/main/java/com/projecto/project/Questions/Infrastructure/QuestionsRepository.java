package com.projecto.project.Questions.Infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.projecto.project.Questions.Domain.Question;

public interface QuestionsRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question WHERE chapter_id = ?1", nativeQuery = true)
    List<Question> buscarQuestionsByIdChapter(Long idChapter);
    
}
