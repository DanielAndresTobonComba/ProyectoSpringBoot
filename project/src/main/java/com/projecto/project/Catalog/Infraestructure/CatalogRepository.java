package com.projecto.project.Catalog.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Catalog.Domain.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog , Long>  {

}
