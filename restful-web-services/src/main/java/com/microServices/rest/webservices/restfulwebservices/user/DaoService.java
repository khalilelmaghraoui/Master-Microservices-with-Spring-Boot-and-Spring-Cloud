package com.microServices.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DaoService {
    private static List<User> users = new ArrayList<User>();

    private static int idCmpt = 3;


    static {
        users.add(new User(1, "khalil", new Date(2020)));
        users.add(new User(2, "abir", new Date(2020)));
        users.add(new User(3, "misk", new Date(2020)));

    }

    public List<User> findAll() {
        return users;
    }

    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++idCmpt);
        }
        users.add(user);
        return user;
    }

    public User GetUserById(int id) {
        for (User user : users
        ) {
            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }

    public User deleteById(int id ){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
