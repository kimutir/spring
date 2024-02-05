package com.example.gb.service;

import com.example.gb.data.model.User;
import com.example.gb.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;
    private final UserRepository userRepository;
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService, UserRepository userRepository) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
        this.userRepository = userRepository;
    }

    public String register(String name, Integer age, String email) {
        User user = userService.createUser(name, age, email);
        userRepository.add(user);
        notificationService.notify("User " + name + " has been added successfully!");
        return "User added.";
    }
}
