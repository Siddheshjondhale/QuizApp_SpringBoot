package com.example.quizApp.controller;

import com.example.quizApp.dataTransferObject.AnswerSubmitDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.QuizSession;
import com.example.quizApp.entity.User;
import com.example.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz") // Path for managing quiz operations
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestBody User user) {
        if (user.getId() != null) {
            return quizService.startQuizSession(user.getId());
        } else {
            throw new IllegalArgumentException("User ID is required to start the quiz");
        }
    }




    // Get a random question for the quiz
    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        Question question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question); // Return 200 OK with a random question
    }

    // Submit the answer for a question
    @PostMapping("/submit")
    public ResponseEntity<Void> submitAnswer(@RequestBody AnswerSubmitDTO answerSubmitDTO) {
        quizService.submitAnswer(answerSubmitDTO.getQuizSessionId(),
                answerSubmitDTO.getQuestionId(),
                answerSubmitDTO.getAnswer());
        return ResponseEntity.ok().build(); // Return 200 OK with no body
    }

    // Get the stats for a specific quiz session
    @GetMapping("/stats/{quizSessionId}")
    public ResponseEntity<QuizSession> getStats(@PathVariable Long quizSessionId) {
        QuizSession stats = quizService.getQuizSessionStats(quizSessionId);
        return ResponseEntity.ok(stats); // Return 200 OK with quiz stats
    }
}
