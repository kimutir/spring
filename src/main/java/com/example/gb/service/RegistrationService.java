package com.example.gb.service;

import com.example.gb.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public String register(String name, Integer age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUser(user);
        notificationService.notify("User " + name + " has been added successfully!");
        return "User added.";
    }
}
