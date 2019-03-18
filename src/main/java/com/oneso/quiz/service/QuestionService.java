package com.oneso.quiz.service;

import com.oneso.quiz.domain.Questions;

public interface QuestionService {

    Questions getQuestions();

    void start(Questions questions);
}
