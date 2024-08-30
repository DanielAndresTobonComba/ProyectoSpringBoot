package com.projecto.project.Chapter.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.project.Chapter.Domain.Chapter;

import com.projecto.project.Chapter.Domain.IChapter;

import com.projecto.project.Chapter.Infrastructure.ChapterRepository;


@Service
public class ChapterServicesImpl implements IChapter{

    @Autowired
    ChapterRepository chapterRepository;

    @Override
    public Page<Chapter> findAll(Pageable pageable) {

        
    // return chapterRepository.findAll(pageable);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    

    




     // @Override
     // public Optional <Chapter> findById(Long id) {
     //     return chapterRepository.findById(id);
     // } 
    

}
