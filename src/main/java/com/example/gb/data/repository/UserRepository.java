package com.example.gb.data.repository;

import com.example.gb.data.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Database imitation
 */
@Component
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    {
        users.add(new User("Mike", 10, "mike@mail.ru"));
        users.add(new User("Paul", 13, "paul@mail.ru"));
        users.add(new User("Olga", 15, "olga@mail.ru"));
        users.add(new User("Helga", 29, "helga@mail.ru"));
        users.add(new User("Tom", 9, "tom@mail.ru"));
    }

    public void add(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
