package com.oneso.quiz.dao;

import com.oneso.quiz.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoSimple implements PersonDao {

    private List<Person> personList = new ArrayList<>();

    public Person findPerson(String firstName, String lastName) {
        for(Person temp : personList) {
            if(temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)) {
                return temp;
            }
        }

        return new Person(firstName, lastName);
    }

    public Person newPerson(String firstName, String lastName) {
        personList.add(new Person(firstName, lastName));
        return new Person(firstName, lastName);
    }
}
