package com.example.tpspring.controller;

import com.example.tpspring.controller.dto.ContactDto;
import com.example.tpspring.controller.dto.LinkNameDto;
import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Linkname;
import com.example.tpspring.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping({"/home" , "/"})
    public String homeListContact(Model model , @RequestParam(value="searchValue", required = false) String searchValue){
        List<Contact> contactList = new ArrayList<>();
        if (searchValue != null){
            contactList = contactService.searchContact(searchValue);
        }else{
           contactList =  contactService.findContactForActualUser();
        }
        model.addAttribute("contacts",contactList);
        return "home";
    }



    @GetMapping("/add")
    public String contactForm(Model model){
        model.addAttribute("contact",new ContactDto());
        return "addContact";
    }

    @PostMapping("/add")
    public String submitContactForm(ContactDto contactDto){
            contactService.createContact(contactDto);
        return "redirect:/contact/home";
    }

    @GetMapping("/update/{id}")
    public String updateContactForm(@PathVariable("id") long idContact,Model model){
        Contact contact = contactService.findContactById(idContact);
        model.addAttribute("contact",ContactDto.from(contact));
        return "updateContact";
    }

    @PostMapping("/update/{id}")
    public String updateContactForm(@PathVariable("id") Long id, ContactDto contactDto){
        contactService.updateContact(contactDto,id);
        return "redirect:/contact/home";
    }


    @GetMapping("/addRelation")
    public String addRelationForm(Model model){
        model.addAttribute("linkName", new LinkNameDto());
        model.addAttribute("contacts",contactService.findContactForActualUser());
        return "addRelation";
    }

    @PostMapping("/addRelation")
    public String submitAddRelation(LinkNameDto linkNameDto){
        contactService.addRelation(linkNameDto);
        return "redirect:/contact/home";
    }

    @GetMapping("/details/{id}")
    public String detailsUser(@PathVariable("id") Long id,Model model){
        model.addAttribute("contact",contactService.findContactById(id));
        return "detailsContact";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserValidation(@PathVariable("id") Long id,Model model){
        model.addAttribute("contact",contactService.findContactById(id));
        return "deleteValidation";
    }

    @PostMapping("/delete/{id}")
    public String submitDeleteUser(@PathVariable("id") Long id){
        contactService.deleteContact(id);
        return "redirect:/contact/home";
    }




}
