package com.example.quizapp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String title;
    @ManyToMany
    private List<Question> questions;
}
