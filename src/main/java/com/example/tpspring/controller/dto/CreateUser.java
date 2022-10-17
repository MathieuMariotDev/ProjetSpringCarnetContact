package com.example.tpspring.controller.dto;

import com.example.tpspring.repository.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class CreateUser {


    private Long idUser;

    private String name;

    private String firstName;

    private String picture;

    private String password;

    private MultipartFile file;

    private String email;

// FOR INIT
    public CreateUser(String name, String firstName, String picture, String password, String email) {
        this.name = name;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.picture = picture;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreateUser() {
    }

    public Users dtoToUser(){
        Users user = new Users();
        user.setEmail(this.email);
        user.setName(this.name);
        user.setFirstName(this.firstName);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(this.password));
        user.setPicture(this.picture);
        return user;
    }

    public static CreateUser fromUser(Users user){
        CreateUser createUser = new CreateUser();
        createUser.setIdUser(user.getIdUser());
        createUser.setPicture(user.getPicture());
        createUser.setEmail(user.getEmail());
        createUser.setPassword(user.getPassword());
        createUser.setName(user.getName());
        createUser.setFirstName(user.getFirstName());
        return createUser;

    }



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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
