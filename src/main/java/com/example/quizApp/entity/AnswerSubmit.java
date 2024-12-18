package com.example.quizApp.entity;

import jakarta.persistence.*;

@Entity
public class AnswerSubmit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private QuizSession quizSession;

    @Override
    public String toString() {
        return "AnswerSubmit{" +
                "id=" + id +
                ", quizSession=" + quizSession +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

    @ManyToOne
    private Question question;

    private String answer;
    private boolean isCorrect;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizSession getQuizSession() {
        return quizSession;
    }

    public void setQuizSession(QuizSession quizSession) {
        this.quizSession = quizSession;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
