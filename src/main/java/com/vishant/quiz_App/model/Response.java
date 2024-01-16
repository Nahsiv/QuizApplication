package com.vishant.quiz_App.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.*;

@Data
@AllArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
