package com.oneso.quiz.service;

import com.oneso.quiz.dao.PersonDao;
import com.oneso.quiz.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DisplayName("Сервис по работе с персонами")
class PersonServiceTest {

    @Mock
    private LocalizationService localizationService;

    @Mock
    private PersonDao personDao;

    private PersonService service;

    @BeforeEach
    void setUp() {
        personDao = spy(PersonDao.class);
        when(personDao.findPerson(anyString(), anyString())).thenReturn(new Person("1", "2"));
        service = new PersonServiceImpl(personDao, localizationService);
    }

    @Test
    @DisplayName("возвращает найденную персону")
    void shouldReturnSearchPerson() {
        assertNotNull(service.getPerson("1", "2"));
    }

    @Test
    @DisplayName("создает новую персону")
    void shouldCreateNewPerson() {
        service = mock(PersonService.class);
        when(service.newPerson()).thenReturn(new Person("1", "2"));

        assertNotNull(service.newPerson());
    }
}
