package com.projecto.project.Roles.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Roles.Domain.IRoles;
import com.projecto.project.Roles.Infrastructure.RolesRepository;

@Service
public class RolesServicesImpl implements IRoles {

    @Autowired
    RolesRepository rolesRepository;

}
