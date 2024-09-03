package com.projecto.project.Chapter.Infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Chapter.Domain.IChapter;


@RestController
@RequestMapping("/chapter")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired
    IChapter chapterService;


    // http://localhost:8090/chapter/create


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

    // http://localhost:8090/chapter/updateChapter/1

    /* 
         "survey": {
        "id": 1
    },
    "chapterNumber": "01",
    "chapterTitle": "Introducción"
     */

    @PutMapping("/updateChapter/{id}") 
    public  Optional <Chapter> updateOne (@PathVariable Long id , @RequestBody Chapter chapter) {

        return chapterService.update(id, chapter);

    }

    // http://localhost:8090/chapter/deleteOne/40

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Chapter> surveyOptional = chapterService.delete(id);
        
        if (surveyOptional.isPresent()) {

            return "Capitulo numero : " + id + " ha sido eliminado";
        }
        

        return "Capitulo numero : " + id + " no existe ";


    }
}