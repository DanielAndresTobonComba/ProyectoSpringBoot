package com.projecto.project.Chapter.Infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Chapter.Application.ChapterServicesImpl;
import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Chapter.Domain.IChapter;
import com.projecto.project.Survey.Domain.Entities.Survey;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/chapter")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired
    IChapter chapterService;


    // http://localhost:8090/chapter/createOne


    /* {
    "survey": {
        "id": 1
    },
    "chapterNumber": "01",
    "chapterTitle": "Introducción"
}
}


*/
    @PostMapping("/create")
    public Chapter createOne(@RequestBody Chapter chapter) {
        
        return chapterService.createOne(chapter) ;
    }
    
    // http://localhost:8090/chapter/findOne/1

    @GetMapping("/findOne/{id}")
    public Optional<Chapter>findOne(@PathVariable long id) {
        
        return chapterService.findById(id);
    }

     //  http://localhost:8090/chapter/findChapterBySurveyId/11

    @GetMapping("/findChapterBySurveyId/{id}")
    public List<Chapter>findChapterBySurveyId(@PathVariable Long id) {
        
        return chapterService.findChaptersByIdSurvey(id);
    }

}
