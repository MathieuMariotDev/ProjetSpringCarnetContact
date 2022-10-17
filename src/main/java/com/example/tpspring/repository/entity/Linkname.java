package com.example.tpspring.repository.entity;

import javax.persistence.*;

@Entity
public class Linkname {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_link")
    private Long idLink;
    @Basic
    @Column(name = "link_name")
    private String linkName;

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact", nullable = false)
    private Contact contactByIdContact;
    @ManyToOne
    @JoinColumn(name = "id_contact_1", referencedColumnName = "id_contact", nullable = false)
    private Contact contactByIdContact1;

    public Long getIdLink() {
        return idLink;
    }

    public void setIdLink(Long idLink) {
        this.idLink = idLink;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }


    public Contact getContactByIdContact() {
        return contactByIdContact;
    }

    public void setContactByIdContact(Contact contactByIdContact) {
        this.contactByIdContact = contactByIdContact;
    }

    public Contact getContactByIdContact1() {
        return contactByIdContact1;
    }

    public void setContactByIdContact1(Contact contactByIdContact1) {
        this.contactByIdContact1 = contactByIdContact1;
    }

    public Linkname(String linkName, Contact contactByIdContact, Contact contactByIdContact1) {
        this.linkName = linkName;
        this.contactByIdContact = contactByIdContact;
        this.contactByIdContact1 = contactByIdContact1;
    }

    public Linkname() {
    }
}
