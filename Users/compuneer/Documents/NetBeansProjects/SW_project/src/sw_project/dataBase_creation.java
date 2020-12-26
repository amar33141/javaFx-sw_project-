package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author compuneer
 */
public class dataBase_creation implements CRUD_operation{
    notification_template obj=new notification_template();
    public boolean creat(int id,String sub,String con,String lang,notification_template obj) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            PreparedStatement ps = myCon.prepareStatement("INSERT into notifications (id ,content,available_language ,subject ) VALUES(?,?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, con);
            ps.setString(3,lang );
            ps.setString(4,sub );


            ps.execute();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
         }


    public notification_template  read(int x,notification_template obj){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            ResultSet myr=mystat.executeQuery("select * from notifications");
            while (myr.next())
            {
                if(x==myr.getInt("id"))
                {
                    obj.id=myr.getInt("id");
                    obj.Available_language=myr.getString("available_language");
                    obj.content=myr.getString("content");
                    obj.subject=myr.getString("subject");
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return obj;
    }
    public boolean update(int id,String sub,String con,String lang,notification_template obj){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            int myrsf=mystat.executeUpdate("update notifications Set content = '"+(con)+"',available_language='"+lang+"',subject= '"+sub
                    +"' where id = "+ id);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean delete(int x,notification_template obj){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            int myrsf=mystat.executeUpdate("Delete from notifications where id = '"+x+"'");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}