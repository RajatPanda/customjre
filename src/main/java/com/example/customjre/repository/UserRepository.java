package com.example.customjre.repository;

import com.example.customjre.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    UserModel findByUserId(String userId);
}
