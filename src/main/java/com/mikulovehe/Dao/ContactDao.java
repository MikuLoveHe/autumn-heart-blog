package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

@Mapper
public interface ContactDao {
    @ResultMap("ContactResultMap")
    void addContact(Contact contact);
}
