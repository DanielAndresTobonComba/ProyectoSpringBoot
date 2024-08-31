package com.projecto.project.Users.Infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Users.Domain.IUsers;
import com.projecto.project.Users.Domain.Users;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
public class UsersControllers {

    @Autowired
    IUsers usersServices;

    @GetMapping
    public List<Users> list() {
        return usersServices.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody Users users, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usersServices.save(users));
    }



    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
