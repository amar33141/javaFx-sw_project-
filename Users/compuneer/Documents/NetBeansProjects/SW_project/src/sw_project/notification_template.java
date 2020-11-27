
package sw_project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class notification_template {
    
    private String subject;
    private String Available_language;
    private String content;
     private int id;

  
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
    public void creat(){
              try {
         Connection myconObj = null ;  //the obj of class connection allows me to connect to database 
         myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/notification_templates", "kareem", "kareem123"); // connecting to database 
         PreparedStatement ps = myconObj.prepareStatement("INSERT into KAREEM.TEMPLATE_TABLE (ID , SUBJECT , CONTENT , AVAILBLE_LANGUAGE) VALUES(?,?,?,?)");
         ps.setInt(1, id);
         ps.setString(2, subject);
         ps.setString(3, content);
         ps.setString(4, Available_language);
         ps.execute();
          
        }
        catch (SQLException E)
        {
           System.out.println("wrong input");
        }
    
    }}
   
