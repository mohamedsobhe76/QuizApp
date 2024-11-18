package com.example.quizapp.Reposatory;

import com.example.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM quizapp.question where category=:category",nativeQuery = true)
     List<Question> findCategory(@Param("category") String category);
    @Query(value ="SELECT * from Question q where q.category = :category LIMIT :qNum " ,nativeQuery = true)
    List<Question> getRandomQuestions(@Param("category") String category,@Param("qNum") int qNum);
}
