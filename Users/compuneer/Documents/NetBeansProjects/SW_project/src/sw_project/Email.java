package com.example.demo;

import java.sql.*;

public class Email implements Sending{
    private static Email object;
    private Email()
    {

    }
    public static Email getInstance()
    {
        if(object==null)
            object=new Email();
        return object;
    }

    public void Send(int id,String massage)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            PreparedStatement ps = myCon.prepareStatement("INSERT into Mail_queue (id,massage) VALUES(?,?)");
            ps.setInt(1, id);
            ps.setString(2,massage);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}