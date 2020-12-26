package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class Notificate {
    String form;
    Sending obj;
    String con;
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String form(@RequestParam(name="id") int id, @RequestParam(name="name") String name, @RequestParam(name="by") String by)
        {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

                Statement mystat = myCon.createStatement();
                ResultSet myr = mystat.executeQuery("select * from notifications");
                while(myr.next())
                {
                    if(id==myr.getInt("id"))
                    {
                        con=myr.getString("content");
                    }
                }
                form= "Dear " + name +" "+con  ;
                if(by.equals("sms"))
                {
                    obj=SMS.getInstance();
                    obj.Send(id,form);

                }
                if(by.equals("mail"))
                {

                    obj=Email.getInstance();
                    obj.Send(id,form);
                }
            }



            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            return form;

    }




}
