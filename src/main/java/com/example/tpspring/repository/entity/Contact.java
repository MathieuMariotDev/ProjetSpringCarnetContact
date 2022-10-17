package com.example.tpspring.repository.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contact")
    private Long idContact;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "firstName")
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

    public Contact() {

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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate date) {
        this.birthdate = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne
    @JoinColumn(name = "id_User", referencedColumnName = "id_User", nullable = false)
    private Users user;
    @OneToMany(mappedBy = "contactByIdContact",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Collection<Linkname> linknamesByIdContact;
    @OneToMany(mappedBy = "contactByIdContact1",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Collection<Linkname> linknamesByIdContact_0;

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


    public Users getUser() {
        return user;
    }

    public void setUser(Users usersByIdUser) {
        this.user = usersByIdUser;
    }

    public Collection<Linkname> getLinknamesByIdContact() {
        return linknamesByIdContact;
    }

    public void setLinknamesByIdContact(Collection<Linkname> linknamesByIdContact) {
        this.linknamesByIdContact = linknamesByIdContact;
    }

    public Collection<Linkname> getLinknamesByIdContact_0() {
        return linknamesByIdContact_0;
    }

    public void setLinknamesByIdContact_0(Collection<Linkname> linknamesByIdContact_0) {
        this.linknamesByIdContact_0 = linknamesByIdContact_0;
    }

    public Contact(String name, String firstName, String picture, String email, LocalDate birthdate, String note, String phone, String relation, String address, String city, Users user) {
        this.name = name;
        this.firstName = firstName;
        this.picture = picture;
        this.email = email;
        this.birthdate = birthdate;
        this.note = note;
        this.phone = phone;
        this.relation = relation;
        this.address = address;
        this.city = city;
        this.user = user;
    }
}
