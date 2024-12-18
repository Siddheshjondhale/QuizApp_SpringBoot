package com.example.quizApp.repository;


import com.example.quizApp.entity.AnswerSubmit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerSubmissionRepository extends JpaRepository<AnswerSubmit, Long> {
}