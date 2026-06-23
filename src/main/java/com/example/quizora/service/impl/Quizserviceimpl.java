package com.example.quizora.service.impl;

import com.example.quizora.entity.Question;
import com.example.quizora.entity.Result;
import com.example.quizora.repository.QuestionRepository;
import com.example.quizora.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Quizserviceimpl implements QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Result evaluateQuiz(Map<Long, String> answers) {

        List<Question> questions = questionRepository.findAll();

        int correct = 0;

        for (Question q : questions) {

            String userAnswer = answers.get(q.getId());

            if (userAnswer != null &&
                    userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                correct++;
            }
        }

        int total = questions.size();
        int wrong = total - correct;

        double score = total > 0
                ? Math.round(((double) correct / total) * 100 * 100.0) / 100.0
                : 0;

        return new Result(total, correct, wrong, score);
    }
}