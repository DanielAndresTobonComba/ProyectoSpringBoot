package com.projecto.project.Users.Domain;

import java.util.List;

public interface IUsers {

    List<Users> findAll();
    Users save(Users user);


}
