package com.example.postservice.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Document("Posts")
public class Post {


    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int postId;

    private static int comments=0;
    private String tilte;
    private String content;
    private User owner;
    private LocalDateTime data;


}
