package com.mikulovehe.pojo;

public class Contact {
    private int contactId;
    private String username;
    private String email;
    private String subject;
    private String content;
    private String addTime;

    public Contact(){}

    public Contact(String username, String email, String subject, String content, String addTime) {
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.addTime = addTime;
    }

    public Contact(String username, String email, String subject, String content) {
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
