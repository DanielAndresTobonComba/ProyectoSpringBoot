package com.projecto.project.Questions.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Questions.Domain.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

}
