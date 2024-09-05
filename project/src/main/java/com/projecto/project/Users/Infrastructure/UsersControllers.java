package com.projecto.project.Users.Infrastructure;


import java.util.List;


import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @Autowired
    // PasswordEncoder passwordEncoder;

    

    @GetMapping
    public List<Users> list() {
        return usersServices.findAll();
    }

    @GetMapping("/{username}")
    public List<Users> findUserByUsername(@PathVariable("username") String username) {
        
        return usersServices.findByUsername(username);
    }

   /* {
			
			"username": "Juan Pablo",
			"password": "1234jp",
			"admin" : true

		}  */

    @PostMapping ("/login")
    public boolean createUser(@Valid @RequestBody Users users) {

        List<Users> userLogIn = usersServices.findByUsername(users.getUsername());

        if (userLogIn.size()==0) {
            usersServices.save(users);
            return true;
        } else {
            
            return false;
        }

        
    }

    @PostMapping("/verify")
    public String verifyUser(@Valid @RequestBody Users users) {
        List<Users> userLogIn = usersServices.findByUsername(users.getUsername());

        if (userLogIn.size()==0) {
            
            return "Usuario NO registrado";
        } else {
            if (userLogIn.get(0).getPassword().equals(new Sha256Hash(users.getPassword(), "f1nd1ngn3m0", 1024).toBase64())) {
                return "Verificado";
            } else {
                 
                return "Contraseña incorrecta";
            }
        }
        
    }
    



    // private ResponseEntity<?> validation(BindingResult result) {
    //     Map<String, String> errors = new HashMap<>();

    //     result.getFieldErrors().forEach(err -> {
    //         errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
    //     });
    //     return ResponseEntity.badRequest().body(errors);
    // }

}
