package com.projecto.project.Survey.Infraestructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Survey.Domain.Entities.Survey;

import jakarta.validation.Valid;

public interface SurveyRepository extends JpaRepository <Survey , Long> {




    

}
