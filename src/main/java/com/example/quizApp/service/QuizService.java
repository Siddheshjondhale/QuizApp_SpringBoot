package com.example.quizApp.service;

import com.example.quizApp.entity.AnswerSubmit;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.QuizSession;
import com.example.quizApp.entity.User;
import com.example.quizApp.repository.AnswerSubmissionRepository;
import com.example.quizApp.repository.QuestionRepository;
import com.example.quizApp.repository.QuizSessionRepository;
import com.example.quizApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private AnswerSubmissionRepository answerSubmissionRepository;

    public QuizSession startQuizSession(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        QuizSession quizSession = new QuizSession();
        quizSession.setUser(user);
        quizSession.setQuestionsAnswered(0);
        quizSession.setCorrectAnswers(0);
        quizSession.setIncorrectAnswers(0);
        return quizSessionRepository.save(quizSession);
    }

    public Question getRandomQuestion() {
        return questionRepository.findRandomQuestion().orElseThrow(() -> new RuntimeException("No questions available"));
    }

    public void submitAnswer(Long quizSessionId, Long questionId, String answer) {
        QuizSession quizSession = quizSessionRepository.findById(quizSessionId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found"));
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean isCorrect = question.getCorrectAnswer().equals(answer);

        AnswerSubmit submission = new AnswerSubmit();
        submission.setQuizSession(quizSession);
        submission.setQuestion(question);
        submission.setAnswer(answer);
        submission.setCorrect(isCorrect);

        answerSubmissionRepository.save(submission);

        // Update quiz session statistics
        quizSession.setQuestionsAnswered(quizSession.getQuestionsAnswered() + 1);
        if (isCorrect) {
            quizSession.setCorrectAnswers(quizSession.getCorrectAnswers() + 1);
        } else {
            quizSession.setIncorrectAnswers(quizSession.getIncorrectAnswers() + 1);
        }
        quizSessionRepository.save(quizSession);
    }

    public QuizSession getQuizSessionStats(Long quizSessionId) {
        return quizSessionRepository.findById(quizSessionId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found"));
    }


}
