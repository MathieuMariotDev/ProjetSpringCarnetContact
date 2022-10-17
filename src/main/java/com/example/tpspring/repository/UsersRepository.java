package com.example.tpspring.repository;

import com.example.tpspring.repository.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users,Long> {

    Users findUsersByEmail(String email);

    List<Users> findUsersByEmailContainsAndFirstNameContains(String email,String name);


}
