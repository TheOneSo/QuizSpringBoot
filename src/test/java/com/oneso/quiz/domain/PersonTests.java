package com.oneso.quiz.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Персона")
class PersonTests {

    @Test
    @DisplayName("корректно создается")
    void shouldCorrectCreator() {
        Person person = new Person("Ivan", "Ivanov");

        assertNotNull(person);
    }

    @Test
    @DisplayName("возвращает имя и фамилию")
    void shouldReturnFullName() {
        Person person = new Person("Ivan", "Ivanov");

        assertEquals("Ivan", person.getFirstName());
        assertEquals("Ivanov", person.getLastName());
        assertNotNull(person.toString());
    }

}
