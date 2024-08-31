package com.projecto.project.Users.Application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.project.Roles.Domain.Roles;
import com.projecto.project.Roles.Infrastructure.RolesRepository;
import com.projecto.project.Users.Domain.IUsers;
import com.projecto.project.Users.Domain.Users;
import com.projecto.project.Users.Infrastructure.UsersRepository;

@Service
public class UsersServiceImpl implements IUsers {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Users save(Users user) {
        Optional<Roles> optionalRoleUser = roleRepository.findByName("Role_User");
        List<Roles> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Roles> optionalRoleAdmin = roleRepository.findByName("Role_Admin");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

}
