package com.oneso.quiz.service;

import com.oneso.quiz.domain.Person;

public interface PersonService {

    Person getPerson(String firstName, String lastName);

    Person newPerson();

    Person newPerson(String firstName, String lastName);
}
