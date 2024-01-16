package com.vishant.quiz_App.dao;

import com.vishant.quiz_App.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByType(String type);

    @Query(value = "SELECT * FROM question q where q.type =:type ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String type, int numQ);
}
