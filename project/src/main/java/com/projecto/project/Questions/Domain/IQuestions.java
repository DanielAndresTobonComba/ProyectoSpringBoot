package com.projecto.project.Questions.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public interface IQuestions {

    Question createOne(Question quetion);

    List<Question> findQuestionByIdSurvey(Long idQuestion);

    Optional<Question> update(Long id, Question question);

    Optional <Question> delete(Long id);
}
