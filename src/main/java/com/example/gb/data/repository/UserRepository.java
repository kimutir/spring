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

    public void add(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
