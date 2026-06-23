package com.example.quizora.services;

import com.example.quizora.entity.Question;
import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);

    List<Question> getAllQuestions();

    void deleteQuestion(Long id);
}