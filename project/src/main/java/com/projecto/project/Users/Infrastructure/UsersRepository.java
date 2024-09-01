package com.projecto.project.Users.Infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Users.Domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findByUsername(String username);

    
    


}
