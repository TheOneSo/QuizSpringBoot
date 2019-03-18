package com.oneso.quiz.dao;

import com.oneso.quiz.domain.Questions;

import java.util.Map;

public interface QuestionDao {

    Questions parsQuestionCSV(String pathCsv);

    Map<String, String> getAllQuestions();

    void addQuestion(String question, String answer);
}
