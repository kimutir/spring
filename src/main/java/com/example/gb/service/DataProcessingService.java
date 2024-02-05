package com.example.gb.service;

import com.example.gb.data.model.User;
import com.example.gb.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DataProcessingService {

    private final UserRepository userRepository;

    @Autowired
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> sortUsersByAge() {
        List<User> users = userRepository.getUsers();
        return users
                .stream()
                .sorted(Comparator.comparing(User::age))
                .toList();
    }

    public List<User> filterUsersByAge(Integer age) {
        List<User> users = userRepository.getUsers();
        return users
                .stream()
                .filter(u -> u.age() > age)
                .toList();
    }

    public Double average() {
        List<User> users = userRepository.getUsers();
        return users
                .stream()
                .mapToInt(User::age)
                .average()
                .orElse(0);
    }
}
