package com.example.tpspring.controller.dto;

import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Users;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class ContactDto {


    private Long idContact;


    private String name;

    private String firstName;

    private String picture;

    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    private String note;

    private String phone;

    private String relation;

    private String address;

    private String city;

    private MultipartFile file;

    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public ContactDto() {
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }




    public Contact createContactToDto(){
        Contact contact = new Contact();
        contact.setPicture(this.picture);
        contact.setName(this.name);
        contact.setFirstName(this.firstName);
        contact.setEmail(this.email);
        contact.setBirthdate(this.birthdate);
        contact.setNote(this.note);
        contact.setPhone(this.phone);
        contact.setRelation(this.relation);
        contact.setAddress(this.address);
        contact.setCity(this.city);
        contact.setUser(this.user);
        return contact;
    }

    public  static ContactDto from(Contact contact){
        ContactDto contactDto = new ContactDto();
        contactDto.setIdContact(contact.getIdContact());
        contactDto.setPicture(contact.getPicture());
        contactDto.setName(contact.getName());
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setEmail(contact.getEmail());
        contactDto.setBirthdate(contact.getBirthdate());
        contactDto.setNote(contact.getNote());
        contactDto.setPhone(contact.getPhone());
        contactDto.setRelation(contact.getRelation());
        contactDto.setAddress(contact.getAddress());
        contactDto.setCity(contact.getCity());
        contactDto.setUser(contact.getUser());
        return contactDto;
    }

}
