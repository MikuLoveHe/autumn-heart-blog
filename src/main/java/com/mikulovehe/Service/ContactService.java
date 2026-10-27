package com.mikulovehe.Service;

import com.mikulovehe.pojo.Contact;
import com.mikulovehe.pojo.Result;

public interface ContactService {
    Result<String> addContact(Contact contact);
}
