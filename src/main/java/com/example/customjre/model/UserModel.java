package com.example.customjre.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "user_record")
public class UserModel {
    @Id
    private String id;
    private String userId;
    private String userName;
    @CreatedDate
    private Date creationDate;
    @LastModifiedDate
    private Date updateDate;
}
