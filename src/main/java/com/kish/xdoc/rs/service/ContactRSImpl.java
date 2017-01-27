package com.kish.xdoc.rs.service;

import com.kish.xdoc.dbo.Contact;
import com.kish.xdoc.dbo.template.ContactJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ThejKishore on 1/3/2017.
 */
@RestController
public class ContactRSImpl {

    @Autowired
    ContactJdbcTemplate contactJdbcTemplate;

    @RequestMapping(value = "/Contacts" , method = RequestMethod.GET)
    public List<Contact> getAllContacts(){
        return contactJdbcTemplate.getContactList();
    }

    @RequestMapping(value = "/Contact/{id}" , method = RequestMethod.GET)
    public Contact getContact(@PathVariable("id") Long contactID){
        return contactJdbcTemplate.getContactByID(contactID);
    }

    @RequestMapping(value = "/Contact" , method = RequestMethod.GET)
    public List<Contact> getContactByName(@RequestParam("name") String name){
         return contactJdbcTemplate.getContactByName(name);
    }


    @RequestMapping(value = "/Contact" , method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact){
        return contactJdbcTemplate.insertContact(contact);
    }

    @RequestMapping(value = "/Contact/{id}" , method = RequestMethod.PUT)
    public Long updateContact(@PathVariable("id") Long contactID,@RequestBody Contact contact){
        return contactJdbcTemplate.updateContact(contactID,contact);
    }

    @RequestMapping(value = "/Contact/{id}" , method = RequestMethod.DELETE)
    public Long updateContact(@PathVariable("id") Long contactID){
        return contactJdbcTemplate.delectContact(contactID);
    }
}
