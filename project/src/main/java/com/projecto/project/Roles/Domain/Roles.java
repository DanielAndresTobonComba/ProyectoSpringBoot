package com.projecto.project.Roles.Domain;

import java.util.Set;

import com.projecto.project.Users.Domain.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    // Esta es la creación de la relación muchos a muchos. Debe ir en las 2 tablas (Users, Roles)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> users;

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

    public Set<Users> getUser() {
        return users;
    }

    public void setUser(Set<Users> users) {
        this.users = users;
    }

    @Override
    public String toString(){
        return "Role [id=" + id + ", name=" + name 
         +"]";
    }

   

    

}
