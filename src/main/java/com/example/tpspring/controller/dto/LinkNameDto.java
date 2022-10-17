package com.example.tpspring.controller.dto;

import com.example.tpspring.repository.entity.Contact;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LinkNameDto {

    private Long idLink;

    private String linkName;

    private String linkName1;


    private Contact contactByIdContact;


    private Contact contactByIdContact1;


    public LinkNameDto() {
    }

    public LinkNameDto(String linkName, String linkName1, Contact contactByIdContact, Contact contactByIdContact1) {
        this.linkName = linkName;
        this.linkName1 = linkName1;
        this.contactByIdContact = contactByIdContact;
        this.contactByIdContact1 = contactByIdContact1;
    }

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

    public String getLinkName1() {
        return linkName1;
    }

    public void setLinkName1(String linkName1) {
        this.linkName1 = linkName1;
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
}
