package com.oneso.quiz.service;

import com.oneso.quiz.dao.PersonDao;
import com.oneso.quiz.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao pDao;

    private final LocalizationService localizationService;

    @Autowired
    public PersonServiceImpl(PersonDao dao, LocalizationService localizationService) {
        this.pDao = dao;
        this.localizationService = localizationService;
    }

    public Person getPerson(String firstName, String lastName) {
        return pDao.findPerson(firstName, lastName);
    }

    public Person newPerson() {
        Scanner in = new Scanner(System.in);

        System.out.printf("%s: ", localizationService.getMessage("newUser.firstName"));
        String firstName = in.nextLine();
        System.out.printf("%s: ", localizationService.getMessage("newUser.lastName"));
        String lastName = in.nextLine();

        return pDao.newPerson(firstName, lastName);
    }
}
