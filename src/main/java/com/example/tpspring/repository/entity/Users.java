package com.example.tpspring.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_User")
    private Long idUser;
    @Basic
    @Column(name = "name")
    private String name;


    private String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user")
    private Collection<Contact> contacts = new ArrayList<>();

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(idUser, users.idUser) && Objects.equals(name, users.name) && Objects.equals(firstName, users.firstName) && Objects.equals(picture, users.picture) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, firstName, picture, password);
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Contact> contactsByIdUser) {
        this.contacts = contactsByIdUser;
    }
}
