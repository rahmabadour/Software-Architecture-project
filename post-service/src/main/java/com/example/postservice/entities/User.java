package com.example.postservice.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Data
@Document("Users")
public class User {
    private int userId;
    private String userName;
}
