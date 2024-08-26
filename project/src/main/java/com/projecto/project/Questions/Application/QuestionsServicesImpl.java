package com.projecto.project.Questions.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Questions;
import com.projecto.project.Questions.Infrastructure.QuestionsRepository;

@Service
public class QuestionsServicesImpl implements IQuestions {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Questions> findById(long id) {
        return questionsRepository.findById(id);
    }

}
