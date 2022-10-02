package com.example.customjre.controller;

import com.example.customjre.model.UserModel;
import com.example.customjre.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/user")
    public UserModel saveUser() {
        return demoService.getUser();
    }
}
