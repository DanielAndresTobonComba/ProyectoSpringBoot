/* package com.projecto.project.Category.Application;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.projecto.project.Category.Domain.Catalog;
import com.projecto.project.Category.Domain.ICatalog;
import com.projecto.project.Category.Infraestructure.CatalogRepository;

@Service
public class CatalogServicesImpl implements ICatalog {

    @Autowired 
    CatalogRepository catalogRepository;

    @Override
    public Catalog createOne(Catalog catalog) {
        
        return catalogRepository.save(catalog);

    }



}
 */