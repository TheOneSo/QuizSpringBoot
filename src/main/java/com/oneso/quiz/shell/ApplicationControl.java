package com.oneso.quiz.shell;

import com.oneso.quiz.domain.Person;
import com.oneso.quiz.domain.Questions;
import com.oneso.quiz.service.LocalizationService;
import com.oneso.quiz.service.PersonService;
import com.oneso.quiz.service.QuestionService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ApplicationControl {

    private final PersonService personService;
    private final QuestionService questionService;
    private final LocalizationService localizationService;

    public ApplicationControl(PersonService personService, QuestionService questionService, LocalizationService localizationService) {
        this.personService = personService;
        this.questionService = questionService;
        this.localizationService = localizationService;
    }

    @ShellMethod("Start application")
    public void start() {
        Person person = personService.newPerson();
        Questions questions = questionService.getQuestions();

        questionService.start(questions);

        System.out.println("--------");
        System.out.println(localizationService.getMessage("goodbye.user", new String[] {person.toString()}));
    }

    @ShellMethod("Create new user")
    public Person createPerson(@ShellOption String firstName, @ShellOption String lastName) {
        return personService.newPerson(firstName, lastName);
    }

    @ShellMethod("Find user")
    public Person findPerson(@ShellOption String firstName, @ShellOption String lastName) {
        return personService.getPerson(firstName, lastName);
    }

    @ShellMethod("Start quiz")
    public void startQuiz() {
        questionService.start(questionService.getQuestions());
    }
}
