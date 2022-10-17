package com.example.tpspring;

import com.example.tpspring.controller.dto.ContactDto;
import com.example.tpspring.controller.dto.CreateUser;
import com.example.tpspring.controller.dto.LinkNameDto;
import com.example.tpspring.repository.ContactRepository;
import com.example.tpspring.repository.LinkNameRepository;
import com.example.tpspring.repository.UsersRepository;
import com.example.tpspring.repository.entity.Contact;
import com.example.tpspring.repository.entity.Linkname;
import com.example.tpspring.repository.entity.Users;
import com.example.tpspring.service.ContactService;
import com.example.tpspring.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TpSpringApplication implements CommandLineRunner {

    // FOR INIT
    StorageService storageService;

    UsersRepository usersRepository;

    ContactRepository contactRepository;

    ContactService contactService;

    LinkNameRepository linkNameRepository;
    // FOR INIT
    public TpSpringApplication(StorageService storageService, UsersRepository usersRepository, ContactRepository contactRepository, ContactService contactService, LinkNameRepository linkNameRepository) {
        this.storageService = storageService;
        this.usersRepository = usersRepository;
        this.contactRepository = contactRepository;
        this.contactService = contactService;
        this.linkNameRepository = linkNameRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TpSpringApplication.class, args);
    }

    // FOR INIT
    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");
        storageService.init();
        Users user  = usersRepository.findUsersByEmail("math.mariot@gmail.com");
        if (user == null){
            CreateUser users = new CreateUser("Mathieu","Mariot","http://localhost:8080/images/photoCOPAM.png","0123","math.mariot@gmail.com");

            usersRepository.save(users.dtoToUser());
            user = usersRepository.findUsersByEmail("math.mariot@gmail.com");
        }


        Contact contactFind1 = contactRepository.findContactByEmail("lanfe669@gmail.com");
        Contact contactFind2 = contactRepository.findContactByEmail("lanfe668@gmail.com");
        Contact contactFind3 = contactRepository.findContactByEmail("lanfe665@gmail.com");

        if (contactFind1 == null && contactFind2 == null && contactFind3 == null){
            Contact contact = new Contact("Clair","Labrou","http://localhost:8080/images/personne1.jpg","lanfe669@gmail.com", LocalDate.now(),"Recontre au coin du lac","0450883627","Très bonne amis","16 rue","bolia",user);
            contactRepository.save(contact);
            Contact contact1 = new Contact("Lolia","Labrou","http://localhost:8080/images/personne2.jpg","lanfe668@gmail.com", LocalDate.now(),"Une connaissance de voyage","0450883626","Très bonne amis","18 rue ","La viplo",user);
            contactRepository.save(contact1);
            Contact contact2 = new Contact("Clair","Labrou","http://localhost:8080/images/personne3.jpg","lanfe665@gmail.com", LocalDate.now(),"Incroyable jongleuse","0450882587","Connaissance","16 rue la folieAngevine","Hundralo",user);
            contactRepository.save(contact2);

           contactFind1 = contactRepository.findContactByEmail("lanfe669@gmail.com");
           contactFind2 = contactRepository.findContactByEmail("lanfe668@gmail.com");
           contactFind3 = contactRepository.findContactByEmail("lanfe665@gmail.com");
        }

        LinkNameDto linkNameDto = new LinkNameDto("Fille","Mère",contactFind1,contactFind2);
        LinkNameDto linkNameDto1 = new LinkNameDto("Soeur","Soeur",contactFind1,contactFind3);
        contactService.addRelation(linkNameDto);
        contactService.addRelation(linkNameDto1);


    }



}
