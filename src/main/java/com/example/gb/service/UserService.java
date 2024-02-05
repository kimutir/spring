package com.example.gb.service;

import com.example.gb.data.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createUser(String name, Integer age, String email) {
        return new User(name, age, email);
    }

}
