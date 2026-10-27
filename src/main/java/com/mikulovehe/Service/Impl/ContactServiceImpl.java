package com.mikulovehe.Service.Impl;

import com.mikulovehe.Dao.ContactDao;
import com.mikulovehe.Service.ContactService;
import com.mikulovehe.pojo.Contact;
import com.mikulovehe.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mikulovehe.Util.nowTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public Result<String> addContact(Contact contact) {

        if (contact == null) {
            throw new IllegalArgumentException("留言为空");
        }
        if (contact.getSubject() == null || contact.getSubject().trim().isEmpty()) {
            throw new IllegalArgumentException("请写上主题");
        }
        if (contact.getSubject().length() > 70) {
            throw new IllegalArgumentException("主题不能超过70个字符，请精简");
        }
        if (contact.getContent() == null || contact.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("内容不能为空");
        }
        if (contact.getUsername() == null || contact.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("名称不能为空");
        }
        if (contact.getUsername().length() > 255) {
            throw new IllegalArgumentException("名称长度超过上限255");
        }
        if (contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("邮箱不能为空");
        }
        if (contact.getEmail().length() > 255) {
            throw new IllegalArgumentException("哪来这么长的邮箱？？？");
        }


        try {
            Contact c = new Contact(contact.getUsername(), contact.getEmail(), contact.getSubject(), contact.getContent(), nowTime.getTime());
            contactDao.addContact(c);
            return Result.success(c.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.fail(400, "发送失败");
        }
    }
}
