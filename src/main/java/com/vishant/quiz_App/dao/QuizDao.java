package com.vishant.quiz_App.dao;

import com.vishant.quiz_App.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;


@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
