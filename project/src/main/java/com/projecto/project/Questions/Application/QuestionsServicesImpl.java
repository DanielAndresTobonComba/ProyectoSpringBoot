package com.projecto.project.Questions.Application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.Questions.Infrastructure.QuestionsRepository;

@Service
public class QuestionsServicesImpl implements IQuestions {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public Question createOne(Question question) {
        return questionsRepository.save(question);
    }

    @Override
    public List<Question> findQuestionByIdChapter(Long idQuestion) {
        return questionsRepository.buscarQuestionsByIdChapter(idQuestion);
    }

    @Override
    public Optional<Question> update(Long id, Question question) {

        Optional<Question> questionOptional = questionsRepository.findById(id);

        if (questionOptional.isPresent()) {
            
            Question chapterDb = questionOptional.orElseThrow();
            
            chapterDb.setComment_question(question.getComment_question());
            chapterDb.setQuestion_number(question.getQuestion_number());

            return Optional.of(questionsRepository.save(chapterDb));
            
        }
        return questionOptional;
    }

    @Override
    public Optional<Question> delete(Long id) {

        Optional<Question> questionOptional = questionsRepository.findById(id);

        questionOptional.ifPresent(questiondb -> {

            questionsRepository.delete(questiondb);

        });
        return questionOptional;
    }

}
