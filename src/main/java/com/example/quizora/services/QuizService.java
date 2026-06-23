package com.example.quizora.services;

import com.example.quizora.entity.Result;
import java.util.Map;

public interface QuizService {

    Result evaluateQuiz(Map<Long, String> answers);

}