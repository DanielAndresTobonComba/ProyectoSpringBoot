package com.projecto.project.Users.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Users.Domain.IUsers;
import com.projecto.project.Users.Infrastructure.UsersRepository;

@Service
public class UsersServiceImpl implements IUsers {

    @Autowired
    UsersRepository usersRepository;

}
