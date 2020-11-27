
package notification_project;


public class involker {

private notification_template obj_t;
private User obj_u;
private String notificate ;
private sending obj_s;

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
