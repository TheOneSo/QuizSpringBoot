package com.oneso.quiz.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Дао для работы с персонами")
class PersonDaoTest {

    @Test
    @DisplayName("корректно создает новую персону")
    void shouldCorrectCreatNewPerson() {
        PersonDaoSimple personDaoSimple = new PersonDaoSimple();

        assertNotNull(personDaoSimple.newPerson("1", "2"));
    }

    @Test
    @DisplayName("хранит персону")
    void shouldStoragePerson() {
        PersonDaoSimple personDaoSimple = new PersonDaoSimple();
        personDaoSimple.newPerson("1", "2");

        assertNotNull(personDaoSimple.findPerson("1", "2"));
    }

    @Test
    @DisplayName("находит нужную персону")
    void shouldFindNeededPerson() {
        PersonDaoSimple personDaoSimple = new PersonDaoSimple();
        personDaoSimple.newPerson("1", "2");
        personDaoSimple.newPerson("3", "4");
        personDaoSimple.newPerson("5", "6");

        assertNotNull(personDaoSimple.findPerson("3", "4"));
    }
}
