package com.oneso.quiz.dao;

import com.oneso.quiz.domain.Person;

public interface PersonDao {

    Person findPerson(String firstName, String lastName);

    Person newPerson(String firstName, String lastName);
}
