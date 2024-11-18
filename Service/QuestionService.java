package com.example.quizapp.Service;

import com.example.quizapp.Entity.Question;
import com.example.quizapp.Reposatory.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getall() {
        try{
        return new ResponseEntity(questionRepo.findAll(), HttpStatus.OK);}
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Optional<Question>> getbyid(int id) {
        try {

                return new ResponseEntity<>(questionRepo.findById(id),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> findCategory(String category) {
        try {
        return new ResponseEntity<>(questionRepo.findCategory(category),HttpStatus.OK);}
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> add(Question question) {
        try {
        questionRepo.save(question);
        return new ResponseEntity<>("sucess",HttpStatus.CREATED);
    }
    catch(Exception e){e.printStackTrace();}
        return new ResponseEntity<>("faild",HttpStatus.BAD_REQUEST);
}


}

