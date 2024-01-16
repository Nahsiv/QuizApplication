package com.vishant.quiz_App.controller;

import com.vishant.quiz_App.model.Question;
import com.vishant.quiz_App.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("type/{type}")
    public ResponseEntity<List<Question>> getQuestionsByType(@PathVariable String type){
        return questionService.getQuestionsByType(type);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestions(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestionById(@PathVariable int id){
        return questionService.deleteQuestionById(id);
    }

    @PutMapping("update")
    public String updateQuestionByID(@RequestBody Question question){
        return questionService.updateQuestionById( question);
    }
}
