package com.example.quizapp.Entity;

import lombok.Data;

@Data
public class WrapperQuestion {
    private int id;
    private String choice1;
    private String choice2;
    private String choice3;
    private String question;

    public WrapperQuestion(int id, String choice1, String choice2, String choice3, String question) {
        this.id = id;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.question = question;
    }
}
