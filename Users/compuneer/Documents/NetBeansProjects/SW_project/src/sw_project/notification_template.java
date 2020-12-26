package com.example.demo;



public class notification_template {

    public int id =0;
    public String subject=null;
    public String Available_language=null;
    public String content=null;



    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAvailable_language(String Available_language) {
        this.Available_language = Available_language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }


    public String getAvailable_language() {
        return Available_language;
    }


    public String getContent() {
        return content;
    }


    public int getId() {
        return id;
    }


}
