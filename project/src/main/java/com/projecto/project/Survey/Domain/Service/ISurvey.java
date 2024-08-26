package com.projecto.project.Survey.Domain.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.projecto.project.Survey.Domain.Entities.Survey;

public interface ISurvey {

    Optional <Survey> findById(Long id); 
    Page<Survey> findAll(Pageable pageable);
}
