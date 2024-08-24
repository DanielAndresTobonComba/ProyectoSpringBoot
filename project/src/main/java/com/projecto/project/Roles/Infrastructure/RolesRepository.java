package com.projecto.project.Roles.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Roles.Domain.Roles;

public interface RolesRepository extends  JpaRepository<Roles, Long> {

}
