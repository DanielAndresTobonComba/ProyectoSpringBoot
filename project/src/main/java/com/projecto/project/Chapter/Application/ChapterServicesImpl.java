package com.projecto.project.Chapter.Application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projecto.project.Chapter.Domain.Chapter;

import com.projecto.project.Chapter.Domain.IChapter;

import com.projecto.project.Chapter.Infrastructure.ChapterRepository;
import com.projecto.project.Survey.Domain.Entities.Survey;


@Service
public class ChapterServicesImpl implements IChapter{

    @Autowired
    ChapterRepository chapterRepository;



    @Override
    public Optional<Chapter> findById(Long id) {
        // TODO Auto-generated method stub
        return chapterRepository.findById(id);
    }



    @Override
    public Chapter createOne(Chapter chapter) {
        
        return chapterRepository.save(chapter);
    }


    @Override
    public List<Chapter> findChaptersByIdSurvey(Long idSurvey) {
        return chapterRepository.buscarByChapterByIdSurvey(idSurvey);
    }

    

    




     // @Override
     // public Optional <Chapter> findById(Long id) {
     //     return chapterRepository.findById(id);
     // } 
    

}
