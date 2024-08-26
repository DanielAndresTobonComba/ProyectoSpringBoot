package com.projecto.project.Questions.Domain;

import java.util.Optional;

public interface IQuestions {

    Optional<Questions> findById(long id);

}
