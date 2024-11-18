package com.example.quizapp.Reposatory;

import com.example.quizapp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
