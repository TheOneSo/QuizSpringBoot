package com.oneso.quiz.service;

import com.oneso.quiz.domain.Person;
import com.oneso.quiz.domain.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements CommandLineRunner {

    private final PersonService personService;
    private final QuestionService questionService;
    private final LocalizationService localizationService;

    @Autowired
    public QuizServiceImpl(PersonService personService, QuestionService questionService, LocalizationService localizationService) {
        this.personService = personService;
        this.questionService = questionService;
        this.localizationService = localizationService;
    }

    @Override
    public void run(String... args) {
        Person person = personService.newPerson();
        Questions questions = questionService.getQuestions();

        questionService.start(questions);

        System.out.println("--------");
        System.out.println(localizationService.getMessage("goodbye.user", new String[] {person.toString()}));
    }
}
