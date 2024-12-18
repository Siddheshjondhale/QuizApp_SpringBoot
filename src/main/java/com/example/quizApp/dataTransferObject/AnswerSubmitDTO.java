package com.example.quizApp.dataTransferObject;


public class AnswerSubmitDTO {

    private Long quizSessionId;
    private Long questionId;
    private String answer;

    public Long getQuizSessionId() {
        return quizSessionId;
    }

    @Override
    public String toString() {
        return "AnswerSubmitDTO{" +
                "quizSessionId=" + quizSessionId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void setQuizSessionId(Long quizSessionId) {
        this.quizSessionId = quizSessionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
// Getters and Setters
}