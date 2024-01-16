package com.vishant.quiz_App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.*;
import java.util.*;

@Data
@Entity
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String option1;
    private String option2;
    private String option3;

    public QuestionWrapper(Integer id, String title, String option1, String option2, String option3) {
        this.id = id;
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}
