package com.example.tpspring.service;

import com.example.tpspring.controller.dto.CreateUser;
import com.example.tpspring.repository.StorageRepository;
import com.example.tpspring.repository.UsersRepository;
import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Users;
import com.example.tpspring.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;

@Service
public class UserService {

    UsersRepository usersRepository;

    StorageRepository storageRepository;

    public UserService(UsersRepository usersRepository, StorageRepository storageRepository) {
        this.usersRepository = usersRepository;
        this.storageRepository = storageRepository;
    }

    public void createUser(CreateUser createUser) {
        MultipartFile picture = createUser.getFile();
        storageRepository.save(picture);
        createUser.setPicture("http://localhost:8080/images/" + picture.getOriginalFilename());
        usersRepository.save(createUser.dtoToUser());

    }

    public Users findUserById(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id:" + id + " doest not exist"));

        return user;
    }

    public void updateUser( CreateUser createUser) {
        Users user = findActualUser();
        if (createUser.getFile().isEmpty() || createUser.getFile() == null) {
            user.setPicture(createUser.getPicture());
        } else {
            MultipartFile picture = createUser.getFile();
            storageRepository.save(picture);
            user.setPicture("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        user.setName(createUser.getName());
        user.setFirstName(createUser.getFirstName());
        user.setEmail(createUser.getEmail());
        String newPassword = createUser.getPassword();
        if (!user.getPassword().equals(newPassword)) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(newPassword));
        }

        usersRepository.save(user);


    }

    public Users findActualUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findUsersByEmail(auth.getName());
        return user;
    }



}
