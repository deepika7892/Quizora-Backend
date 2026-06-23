package com.example.quizora.controller;

import com.example.quizora.entity.Question;
import com.example.quizora.entity.Result;
import com.example.quizora.repository.QuestionRepository;
import com.example.quizora.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Question> getQuiz() {
        return questionRepository.findAll();
    }

    @PostMapping("/submit")
    public Result submitQuiz(@RequestBody Map<Long, String> answers) {
        return quizService.evaluateQuiz(answers);
    }
}