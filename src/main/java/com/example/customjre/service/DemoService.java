package com.example.customjre.service;

import com.example.customjre.model.UserModel;
import com.example.customjre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoService {
    private final UserRepository userRepository;

    @Autowired
    public DemoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct()
    public void setDefaultUser(){
        UserModel userModel = new UserModel();
        userModel.setUserId("RA1");
        userModel.setUserName("Rajat");
        userRepository.save(userModel);
    }

    public UserModel getUser(){
        return userRepository.findByUserId("RA1");
    }
}
