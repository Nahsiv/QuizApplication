package com.vishant.quiz_App.service;

import com.vishant.quiz_App.model.Question;
import com.vishant.quiz_App.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
        return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);}
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByType(String type) {
        try{
        return new ResponseEntity<>(questiondao.findByType(type), HttpStatus.OK);}
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestions(Question question) {
        questiondao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public String deleteQuestionById(int id) {
        questiondao.deleteById(id);
        return "success";
    }

    public String updateQuestionById( Question question) {
        questiondao.save(question);
        return "success";
    }
}
