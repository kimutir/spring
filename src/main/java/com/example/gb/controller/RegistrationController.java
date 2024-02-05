package com.example.gb.controller;

import com.example.gb.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> register(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("email") String email
    ) {
        String res = registrationService.register(name, age, email);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
