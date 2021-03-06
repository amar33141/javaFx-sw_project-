package com.example.demo;

import org.springframework.web.bind.annotation.*;



@RestController
public class notificationTemplatesController{
    CRUD_operation obj=new dataBase_creation();


@RequestMapping(value = "/create",method = RequestMethod.POST)
public boolean creat(@RequestParam(name="id") int id,@RequestParam(name="content") String con,@RequestParam(name="langauge") String avl,@RequestParam(name="subject") String sub,notification_template o)
{
   return obj.creat(id,sub,con,avl,o);
}

@RequestMapping(value = "/update",method = RequestMethod.PUT)
    public boolean update(@RequestParam(name="id") int id,@RequestParam(name="content") String con,@RequestParam(name="langauge") String avl,@RequestParam(name="subject") String sub,notification_template o)
    {
        return obj.update(id,sub,con,avl,o);
    }

@RequestMapping(value = "/read",method = RequestMethod.GET)
    public notification_template read(@RequestParam(name="id") int id,notification_template o)
    {
        return obj.read(id,o);
    }

@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public boolean delete(int id ,notification_template o)
    {
        return obj.delete(id,o);

    }

}
