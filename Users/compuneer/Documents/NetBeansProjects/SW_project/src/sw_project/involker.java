/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw_project;

/**
 *
 * @author compuneer
 */
public class involker {
private notification_template obj_t;
private User obj_u;
private String notificate ;
private Sending obj_s;

    public String getNotificate() {
        return notificate;
    }

    public void setNotificate(String notificate) {
        this.notificate = notificate;
    }
   
       public String form(User obj){
        obj_t = new notification_template();
       
      notificate = "Dear " +obj.getName()+ " your " + obj_t.read(obj.getId()) + " has been confirmed" ;
        return notificate ;
    }
    public void sendMail(String notificate){
        obj_s =  new email ();
       obj_s.Send(notificate, obj_u);
    }
    
}