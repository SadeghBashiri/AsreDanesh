package com.asredanesh.demo.services;

import com.asredanesh.demo.dto.ContactDto;
import com.asredanesh.demo.dto.ContactSearchDto;
import com.asredanesh.demo.entities.Contact;
import com.asredanesh.demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contact.setEmail(contactDto.getEmail());
        contact.setOrganization(contactDto.getOrganization());
        contact.setGithub(contactDto.getGithub());
        Contact saveContact = contactRepository.save(contact);
        Optional<Contact> updateContact = contactRepository.findById(saveContact.getId());
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        updateContact.get().setGithubCount(rand_int1);
        Contact save = contactRepository.save(updateContact.get());
        return save;
    }

    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

//    public List<Contact> findByAllColumns(String name, String email, String phoneNumber){
//        return contactRepository.findByAllColumns(name, email, phoneNumber);
//    }

    public List<Contact> findByNameOrEmailOrPhoneNumberOrGithub(ContactSearchDto contactSearchDto) {
        String name = contactSearchDto.getName();
        String email = contactSearchDto.getEmail();
        String phoneNumber = contactSearchDto.getPhoneNumber();
        String github  = contactSearchDto.getGithub();
        return contactRepository.findByNameOrEmailOrPhoneNumberOrGithub(name, email, phoneNumber, github);
    }
}
