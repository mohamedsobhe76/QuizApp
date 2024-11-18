package com.example.quizapp.Service;

import com.example.quizapp.Entity.Question;
import com.example.quizapp.Entity.Quiz;
import com.example.quizapp.Entity.WrapperQuestion;
import com.example.quizapp.Reposatory.QuestionRepo;
import com.example.quizapp.Reposatory.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> getquiz(String category, int qNum, String title) {
        List<Question> questions = questionRepo.getRandomQuestions(category,qNum);
        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<WrapperQuestion>> GetTheQuestions(int id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questionsFromDB = quiz.getQuestions();
        List<WrapperQuestion> wrapperQuestions = new ArrayList<>();
        for (Question q : questionsFromDB) {
            WrapperQuestion qs =new WrapperQuestion(q.getId(),q.getChoice1(),q.getChoice2(),q.getChoice3(),q.getQuestion());
            wrapperQuestions.add(qs);
        }
        return new ResponseEntity<List<WrapperQuestion>>(wrapperQuestions,HttpStatus.OK);

    }
}
