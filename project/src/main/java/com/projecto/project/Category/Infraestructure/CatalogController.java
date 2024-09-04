/* package com.projecto.project.Category.Infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Category.Domain.Catalog;
import com.projecto.project.Category.Domain.ICatalog;
import com.projecto.project.Chapter.Domain.Chapter;

@RestController
@RequestMapping("/catalog")
@CrossOrigin("*")
public class CatalogController {

    @Autowired 
    private ICatalog serviciCatalog;

    // http://localhost:8090/catalog/createOne

    @PostMapping("/createOne")
    public Catalog createOne(@RequestBody Catalog catalog) {
        
        return serviciCatalog.createOne(catalog) ;
    }
}
 */