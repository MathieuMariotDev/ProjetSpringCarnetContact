package com.example.tpspring.service;

import com.example.tpspring.controller.dto.ContactDto;
import com.example.tpspring.controller.dto.LinkNameDto;
import com.example.tpspring.repository.ContactRepository;
import com.example.tpspring.repository.LinkNameRepository;
import com.example.tpspring.repository.StorageRepository;
import com.example.tpspring.repository.UsersRepository;
import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Linkname;
import com.example.tpspring.repository.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class ContactService {

    ContactRepository contactRepository;

    StorageRepository storageRepository;

    UsersRepository usersRepository;

    LinkNameRepository  linkNameRepository;

    public ContactService(ContactRepository contactRepository, StorageRepository storageRepository, UsersRepository usersRepository, LinkNameRepository linkNameRepository) {
        this.contactRepository = contactRepository;
        this.storageRepository = storageRepository;
        this.usersRepository = usersRepository;
        this.linkNameRepository = linkNameRepository;
    }

    public List<Contact> findContactForActualUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findUsersByEmail(auth.getName());
        return contactRepository.findContactByUser(user);
    }

    public void addRelation(LinkNameDto linkNameDto){
        Linkname linknameX = new Linkname(linkNameDto.getLinkName(), linkNameDto.getContactByIdContact(), linkNameDto.getContactByIdContact1());
        Linkname linknameY = new Linkname(linkNameDto.getLinkName1(), linkNameDto.getContactByIdContact1(), linkNameDto.getContactByIdContact());
        linkNameRepository.save(linknameX);
        linkNameRepository.save(linknameY);
    }

    public void deleteContact(Long id){
        Contact contact = findContactById(id);
        contactRepository.delete(contact);
    }

    public List<Contact> searchContact(String searchValue){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findUsersByEmail(auth.getName());

        return contactRepository.findContactsByUserAndNameContainingOrAddressContainingOrFirstNameContainingOrPhoneContainingOrCityContainingOrNoteContainingOrRelationContaining(user,searchValue,searchValue,searchValue,searchValue,searchValue,searchValue,searchValue);
    }



    public void createContact(ContactDto contactDto){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findUsersByEmail(auth.getName());

        contactDto.setUser(user);
        if (contactDto.getFile().isEmpty() || contactDto.getFile() == null){
            contactDto.setPicture("http://localhost:8080/images/" + "default.jpg");
        }else{
            MultipartFile picture = contactDto.getFile();
            storageRepository.save(picture);
            contactDto.setPicture("http://localhost:8080/images/" + picture.getOriginalFilename());
        }
        contactRepository.save(contactDto.createContactToDto());
    }

    public Contact findContactById(Long id){
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact with id:"+id+" doest not exist"));
        return contact;
    }

    public void updateContact(ContactDto contactDto, Long id){
        Contact contact =findContactById(id);
        if (contactDto.getFile().isEmpty() || contactDto.getFile() == null){
            contact.setPicture(contactDto.getPicture());
        }else{
            MultipartFile picture = contactDto.getFile();
            storageRepository.save(picture);
            contact.setPicture("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        contact.setName(contactDto.getName());
        contact.setFirstName(contactDto.getFirstName());
        contact.setEmail(contactDto.getEmail());
        contact.setBirthdate(contactDto.getBirthdate());
        contact.setNote(contactDto.getNote());
        contact.setPhone(contactDto.getPhone());
        contact.setRelation(contactDto.getRelation());
        contact.setAddress(contactDto.getAddress());
        contact.setCity(contactDto.getCity());
        contact.setIdContact(contact.getIdContact());
        contactRepository.save(contact);
    }

}
