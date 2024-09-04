package com.projecto.project.Catalog.Application;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.projecto.project.Catalog.Domain.Catalog;
import com.projecto.project.Catalog.Domain.ICatalog;
import com.projecto.project.Catalog.Infraestructure.CatalogRepository;

@Service
public class CatalogServicesImpl implements ICatalog {

    @Autowired 
    CatalogRepository catalogRepository;

    @Override
    public Catalog createOne(Catalog catalog) {
        
        return catalogRepository.save(catalog);

    }



}
