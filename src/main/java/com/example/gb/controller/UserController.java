package com.example.gb.controller;

import com.example.gb.data.model.User;
import com.example.gb.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final DataProcessingService processingService;
    @Autowired
    public UserController(DataProcessingService processingService) {
        this.processingService = processingService;
    }

    @GetMapping("/sort")
    public ResponseEntity<List<User>> getSorted() {
        return new ResponseEntity<>(processingService.sortUsersByAge(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<User>> getFiltered(
            @RequestParam("age") Integer age
    ) {
        return new ResponseEntity<>(processingService.filterUsersByAge(age), HttpStatus.OK);
    }

    @GetMapping("/avg")
    public ResponseEntity<Double> getAverage() {
        return new ResponseEntity<>(processingService.average(), HttpStatus.OK);
    }
}
