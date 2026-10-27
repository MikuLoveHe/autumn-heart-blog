package com.mikulovehe.Controller;

import com.mikulovehe.Service.ContactService;
import com.mikulovehe.pojo.Contact;
import com.mikulovehe.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public Result<String> addContact(@RequestBody Contact contact){
        System.out.println(contact.toString());
       return contactService.addContact(contact);
    }
}
