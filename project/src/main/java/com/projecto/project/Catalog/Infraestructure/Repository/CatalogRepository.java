package com.projecto.project.Catalog.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Catalog.Domain.Entities.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog , Long>  {

}
