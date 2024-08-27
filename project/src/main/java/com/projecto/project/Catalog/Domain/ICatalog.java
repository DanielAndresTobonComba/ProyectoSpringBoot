package com.projecto.project.Catalog.Domain;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICatalog {

    Optional <Catalog> findById(Long id); 
    Page <Catalog> findAll(Pageable pageable);

}
