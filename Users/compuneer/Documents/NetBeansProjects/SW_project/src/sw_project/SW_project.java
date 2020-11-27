
package sw_project;


public class SW_project {

    
    public static void main(String[] args) {
                System.out.println("Welcome to fly with us company");
        while (true) {
            System.out.println("choose from the following:  1-invoker  2-customer  3-exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 3) {
                break;
            }

            if (choice == 1) {
                while (true) {
                    System.out.println("choose from the list of operations on notification templates:  1-create  2-read  3-update  4-delete  5-exit");
                    int choicee = sc.nextInt();
                    if (choicee == 1) {
                        Scanner scc = new Scanner(System.in);
                        notification_template obj = new notification_template();
                        System.out.println("please assign id to this new template: ");
                        int id = sc.nextInt();
                        obj.setId(id);
                        System.out.println("please enter the template subject: ");
                        String s = new String();
                        s = scc.nextLine();
                        obj.setSubject(s);
                        System.out.println("please enter the template content: ");
                        String f = new String();
                        f = scc.nextLine();
                        obj.setContent(f);
                        System.out.println("please enter the template language: ");
                        s = scc.nextLine();
                        obj.setAvailable_language(s);
                        obj.creat();
                    } else if (choicee == 2) {
                        String l = new String();
                        notification_template obj = new notification_template();
                        System.out.println("enter the id of template you wanna read: ");
                        int idd = sc.nextInt();
                        l = obj.read(idd);
                        if (l.equalsIgnoreCase(null)) {
                            System.out.println("this template doesnt exist: ");
                        }

                    } else if (choicee == 3) {
                        notification_template obj = new notification_template();
                        System.out.println("enter the id of template you wanna update: ");
                        int idd = sc.nextInt();

                        Scanner scc = new Scanner(System.in);
                        System.out.println("please assign id to this new template: ");
                        int id = sc.nextInt();
                        obj.setId(id);
                        System.out.println("please enter the template subject: ");
                        String s = new String();
                        s = scc.nextLine();
                        obj.setSubject(s);
                        System.out.println("please enter the template content: ");
                        String f = new String();
                        f = scc.nextLine();
                        obj.setContent(f);
                        System.out.println("please enter the template language: ");
                        s = scc.nextLine();
                        obj.setAvailable_language(s);

                        obj.ubdate(idd);
                    } else if (choicee == 4) {
                        notification_template obj = new notification_template();
                        System.out.println("enter the id of template you wanna delete: ");
                        int idd = sc.nextInt();
                        obj.delete(idd);
                    } else if (choicee == 5) {
                        break;
                    }
                }
            } else if (choice == 2) {
                User obj = new User();
                while (true) {

                    invoker obj_i = new invoker();
                    System.out.println("choose from the following:  1-sign up   2-login  3-book a flight  4-cancell a flight  5-exit  6-for any new template");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        Scanner scc = new Scanner(System.in);
                        System.out.println("please enter your name: ");
                        String f = new String();
                        f = scc.nextLine();
                        obj.setName(f);
                        System.out.println("please enter your email: ");
                        f = scc.nextLine();
                        obj.setEmail(f);
                        System.out.println("please enter your mobile number: ");
                        int s = scc.nextInt();
                        obj.setMobileNum(f);
                        System.out.println("please enter your language: ");
                        Scanner sccc = new Scanner(System.in);
                        f = sccc.nextLine();
                        obj.setLanguage(f);
                        obj.setSubject("sign up");
                        obj.setId(1);
                        obj_i.sendMail(obj_i.form(obj));

                    } else if (ch == 2) {
                        Scanner scc = new Scanner(System.in);
                        obj.setId(2);
                        System.out.println("please enter your email: ");
                        scc.nextLine();
                        System.out.println("please enter your password: ");
                        scc.nextLine();
                        obj_i.sendMail(obj_i.form(obj));

                    } else if (ch == 3) {
                        Scanner sccc = new Scanner(System.in);
                        obj.setId(3);
                        System.out.println("please enter your destination: ");
                        sccc.nextLine();
                        System.out.println("please enter the day: ");
                        sccc.nextLine();
                        obj_i.sendMail(obj_i.form(obj));

                    } else if (ch == 4) {
                        Scanner sccc = new Scanner(System.in);
                        obj.setId(4);
                        System.out.println("please enter your destination: ");
                        sccc.nextLine();
                        System.out.println("please enter reservation day: ");
                        sccc.nextLine();
                        obj_i.sendMail(obj_i.form(obj));
                    } else if (ch == 5) {
                        break;
                    } else if (ch == 6) {
                        Scanner sccc = new Scanner(System.in);
                        System.out.println("please enter template id: ");
                        int id = sccc.nextInt();
                        obj.setId(id);
                        obj_i.sendMail(obj_i.form(obj));

                    }
                }
            }
        }
    }
    
}
