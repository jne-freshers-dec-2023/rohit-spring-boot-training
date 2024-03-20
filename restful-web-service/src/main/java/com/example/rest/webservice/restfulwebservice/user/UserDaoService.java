package com.example.rest.webservice.restfulwebservice.user;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users= new ArrayList<>();

    static
    {
        users.add(new User(1,"Rohit", LocalDate.now().minusYears(24)));
        users.add(new User(2,"Kartik",LocalDate.now().minusYears(12)));
        users.add(new User(3,"Pavan", LocalDate.now().minusYears(30)));
    }

    public List<User> getAllUsers()
    {
        return users;
    }

    public User getUser(int id)
    {
        try {
            User user = users.get(id);
            return  user;
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public void saveUser(User user)
    {
//        LocalDate lt = LocalDate.parse("2024-12-23");
        users.add(user);
    }

    public User deleteUser(int id)
    {
        try
        {
            User user=users.get(id);
            users.remove(user);
            return user;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
