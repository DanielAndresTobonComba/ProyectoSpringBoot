package com.projecto.project.Chapter.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Chapter.Domain.IChapter;
import com.projecto.project.Chapter.Infrastructure.ChapterRepository;

@Service
public class ChapterServicesImpl implements IChapter{

    @Autowired
    ChapterRepository chapterRepository;


    


    

}
