package com.example.demo;

import java.sql.*;

public class SMS implements Sending{

    private static SMS object;
    private SMS()
    {

    }
    public static SMS getInstance()
    {
        if(object==null)
            object=new SMS();
        return object;
    }

    public void Send(int id,String massage){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            PreparedStatement ps = myCon.prepareStatement("INSERT into SMS_queue (id,massage) VALUES(?,?)");
            ps.setInt(1, id);
            ps.setString(2, massage);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public void dequeue() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/notification_template", "root", "");

            Statement mystat = myCon.createStatement();
            System.out.println("your notifications Sending now by sms....");

            ResultSet myrs=mystat.executeQuery("select * from SMS_queue");
            int z=0;
            while (myrs.next())
            {
                z=myrs.getInt("id");
                System.out.println(myrs.getString("massage")+" by SMS");

            }
            int myrssf=mystat.executeUpdate("Delete from SMS_queue ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
