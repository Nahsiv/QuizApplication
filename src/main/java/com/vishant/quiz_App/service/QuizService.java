package com.vishant.quiz_App.service;

import com.vishant.quiz_App.dao.QuestionDao;
import com.vishant.quiz_App.dao.QuizDao;
import com.vishant.quiz_App.model.Question;
import com.vishant.quiz_App.model.QuestionWrapper;
import com.vishant.quiz_App.model.Quiz;
import com.vishant.quiz_App.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String type, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(type, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quizFromDb = quizDao.findById(id);
        List<Question> questionsFromDB = quizFromDb.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper s = new QuestionWrapper(q.getId(), q.getTitle(), q.getOption1(),q.getOption2(), q.getOption3());
            questionsForUser.add(s);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
    public ResponseEntity<Integer> getResult(Integer id, List<Response> response) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int marks = 0;
        int track = 0;
        for(Response resp:response){
            if(resp.getResponse().equals(questions.get(track).getAnswer())){
                marks++;
            }
            track++;
        }
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
}