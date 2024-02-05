package com.example.gb.controller;

import com.example.gb.data.model.User;
import com.example.gb.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserViewController {

    private final DataProcessingService processingService;
    @Autowired
    public UserViewController(DataProcessingService processingService) {
        this.processingService = processingService;
    }

    @GetMapping("/sort")
    public String getSorted(
            Model model
    ) {
        List<User> users = processingService.sortUsersByAge();
        model.addAttribute("users", users);
        model.addAttribute("type", "Sorted");
        return "users";
    }

    @GetMapping("/filter")
    public String getFiltered(
            @RequestParam("age") Integer age,
            Model model
    ) {
        List<User> users = processingService.filterUsersByAge(age);
        model.addAttribute("users", users);
        model.addAttribute("type", "Filtered");
        return "users";
    }

}
