package com.example.tpspring.repository;

import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ContactRepository  extends CrudRepository<Contact,Long> {

    List<Contact> findContactByUser(Users user);

    List<Contact> findContactsByUserAndNameContainingOrAddressContainingOrFirstNameContainingOrPhoneContainingOrCityContainingOrNoteContainingOrRelationContaining(Users user, String name, String address, String firstName, String phone, String city, String note, String relation);


    // FOR INIT

    Contact findContactByEmail(String email);

}
