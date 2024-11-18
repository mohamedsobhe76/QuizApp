package com.example.quizapp.Controller;

import com.example.quizapp.Entity.WrapperQuestion;
import com.example.quizapp.Service.QuestionService;
import com.example.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> CreatQuiz(@RequestParam String category,@RequestParam int qNum,@RequestParam String title){
        return quizService.getquiz(category,qNum,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<WrapperQuestion>> GetQuizQuestions(@PathVariable int id){
        return quizService.GetTheQuestions(id);
    }

}
