package com.example.quizapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Primary;

@Entity
@Data
public class Question {
    @Id
    private int id;
    private String choice1;
    private String choice2;
    private String choice3;
    private String correct;
    private String question;
    private String Category;
    private String difficult;


}
