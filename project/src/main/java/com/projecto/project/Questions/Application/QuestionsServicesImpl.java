package com.projecto.project.Questions.Application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.Questions.Infrastructure.QuestionsRepository;

@Service
public class QuestionsServicesImpl implements IQuestions {

    @Autowired
    QuestionsRepository questionsRepository;



    @Override
    public Question createOne(Question quetion) {
        return questionsRepository.save(quetion);
    }

    @Override
    public List<Question> findQuestionByIdSurvey(Long idQuestion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findQuestionByIdSurvey'");
    }

    @Override
    public Optional<Question> update(Long id, Question question) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Question> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
