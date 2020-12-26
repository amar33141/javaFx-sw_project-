package com.example.demo;

public interface CRUD_operation {
    public boolean creat(int id,String sub,String con,String lang,notification_template obj);
    public boolean update(int id,String sub,String con,String lang,notification_template obj);
    public boolean delete(int x,notification_template obj);
    public notification_template  read(int x, notification_template obj);
}
