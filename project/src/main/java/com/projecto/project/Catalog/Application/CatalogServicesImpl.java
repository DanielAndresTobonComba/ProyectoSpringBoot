package com.projecto.project.Catalog.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.project.Catalog.Domain.Catalog;
import com.projecto.project.Catalog.Domain.ICatalog;
import com.projecto.project.Catalog.Infraestructure.CatalogRepository;

public class CatalogServicesImpl implements ICatalog {

    @Autowired 
    CatalogRepository catalogRepository;

    @Override
    public Optional<Catalog> findById(Long id) {
        return  catalogRepository.findById(id);
    }

    @Override
    public Page<Catalog> findAll(Pageable pageable) {
       return catalogRepository.findAll(pageable);
    }

}
