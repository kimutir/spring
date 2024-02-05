package com.example.gb.service;

import com.example.gb.data.model.User;
import com.example.gb.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {

    private final UserRepository userRepository;
    @Autowired
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.add(user);
    }
}
