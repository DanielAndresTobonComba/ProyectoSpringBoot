package com.projecto.project.Categories_Survey.Application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Categories_Survey.Domain.Entities.SurveyCategory;
import com.projecto.project.Categories_Survey.Domain.Services.ISurveyCategory;
import com.projecto.project.Categories_Survey.Infrastructure.SurveyCategoryRepository;

@Service
public class SuveryCategoryServices implements ISurveyCategory {

    @Autowired
    SurveyCategoryRepository surveyCategoryRepository;

	@Override
	public List<SurveyCategory> extractCategories() {
		
		return surveyCategoryRepository.findAll();
	}

    

}
