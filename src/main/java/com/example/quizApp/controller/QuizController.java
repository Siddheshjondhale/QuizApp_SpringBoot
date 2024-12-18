package com.example.quizApp.controller;

import com.example.quizApp.dataTransferObject.AnswerSubmitDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.QuizSession;
import com.example.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestBody Long userId) {
        return quizService.startQuizSession(userId);
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public void submitAnswer(@RequestBody AnswerSubmitDTO answerSubmissionDTO) {
        quizService.submitAnswer(answerSubmissionDTO.getQuizSessionId(), answerSubmissionDTO.getQuestionId(), answerSubmissionDTO.getAnswer());
    }

    @GetMapping("/stats/{quizSessionId}")
    public QuizSession getStats(@PathVariable Long quizSessionId) {
        return quizService.getQuizSessionStats(quizSessionId);
    }



}
