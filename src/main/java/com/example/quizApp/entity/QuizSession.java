package com.example.quizApp.entity;


import jakarta.persistence.*;

import java.util.concurrent.ThreadLocalRandom;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_session_seq")
    @SequenceGenerator(name = "quiz_session_seq", sequenceName = "quiz_session_seq", initialValue = 1000001, allocationSize = 1)
    private Long id;

    @ManyToOne
    private User user;

    private int questionsAnswered;
    private int correctAnswers;
    private int incorrectAnswers;



    @Override
    public String toString() {
        return "QuizSession{" +
                "id=" + id +
                ", user=" + user +
                ", questionsAnswered=" + questionsAnswered +
                ", correctAnswers=" + correctAnswers +
                ", incorrectAnswers=" + incorrectAnswers +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }

    public void setQuestionsAnswered(int questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
