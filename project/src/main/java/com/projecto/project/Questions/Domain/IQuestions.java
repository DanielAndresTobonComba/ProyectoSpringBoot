package com.projecto.project.Questions.Domain;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestions {

    Optional<Questions> findById(long id);
    Page <Questions> findAll(Pageable pageable);

}
