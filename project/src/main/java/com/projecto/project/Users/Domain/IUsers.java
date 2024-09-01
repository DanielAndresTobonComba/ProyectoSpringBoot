package com.projecto.project.Users.Domain;

import java.util.List;
import java.util.Optional;

public interface IUsers {

    List<Users> findAll();
    Users save(Users user);
    List<Users> findByUsername(String username);
    Optional<Users> findById(long id);


}
