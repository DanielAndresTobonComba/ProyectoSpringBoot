package com.projecto.project.Roles.Domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projecto.project.Users.Domain.Users;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Esta es la creación de la relación muchos a muchos. Debe ir en las 2 tablas (Users, Roles)
    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

    public Roles() {}

    public Roles(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUser() {
        return users;
    }

    public void setUser(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString(){
        return "Role [id=" + id + ", name=" + name 
         +"]";
    }

   

    

}
