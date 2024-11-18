package com.example.quizapp.Controller;

import com.example.quizapp.Entity.Question;
import com.example.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allquestion")
    public ResponseEntity<List<Question>> GetAllQuestions(){
        return questionService.getall();
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Question>> Getbyid(@PathVariable int id ){
        return questionService.getbyid(id);
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> GetByCategory(@PathVariable String category){
        return questionService.findCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addquestion(@RequestBody Question question){
        return questionService.add(question);
    }


}
