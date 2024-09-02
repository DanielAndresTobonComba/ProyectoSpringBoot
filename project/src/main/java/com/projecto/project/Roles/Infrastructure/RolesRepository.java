package com.projecto.project.Roles.Infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Roles.Domain.Roles;

public interface RolesRepository extends  JpaRepository<Roles, Long> {

    Optional<Roles> findByName(String name);

    

}
