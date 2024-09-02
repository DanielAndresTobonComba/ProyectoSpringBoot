package com.projecto.project.Chapter.Infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Chapter.Application.ChapterServicesImpl;
import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Chapter.Domain.IChapter;
import com.projecto.project.Survey.Domain.Entities.Survey;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Chapters")
public class ChapterController {

    @Autowired
    IChapter chapterService;

    // http://localhost:8090/Chapters/createOne

    /* 		{
			"survey_id" : 1,
			"chapter_number": "1",
			"chapter_title": "la creacion de un capitulo"

		}*/


    // REVIZAR
    @PostMapping("/createOne")
    public Chapter createOneChapter(@RequestBody Chapter chapter) {
        
        return chapterService.createOne(chapter) ;
    }
    
    // http://localhost:8090/Chapters/findOne/1
    @GetMapping("/findOne/{id}")
    public Optional<Chapter>findOne(@PathVariable long id) {

        return chapterService.findById(id);
    }

}
