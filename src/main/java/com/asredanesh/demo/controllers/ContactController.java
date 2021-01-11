package com.asredanesh.demo.controllers;

import com.asredanesh.demo.dto.ContactDto;
import com.asredanesh.demo.dto.ContactSearchDto;
import com.asredanesh.demo.entities.Contact;
import com.asredanesh.demo.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;



    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PutMapping("/contacts")
    public Contact register(@RequestBody @Valid ContactDto contactDto) {
        Contact saveContact = contactService.saveContact(contactDto);
        return saveContact;
    }

    @PostMapping("/list")
    public List<Contact> getContacts(@RequestBody ContactSearchDto contactSearchDto) {
        return contactService.findByNameOrEmailOrPhoneNumberOrGithub(contactSearchDto);
    }
}
