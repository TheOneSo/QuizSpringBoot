package com.oneso.quiz.config;

import com.oneso.quiz.domain.Person;
import com.oneso.quiz.service.LocalizationService;
import com.oneso.quiz.service.PersonService;
import com.oneso.quiz.service.QuestionService;
import com.oneso.quiz.service.QuizServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Конфигурация для локали")
class LocalizationConfigTest {

    @MockBean
    QuizServiceImpl quizService;

//    @SpyBean
//    private PersonService personService;
//    @SpyBean
//    private QuestionService questionService;

    @Test
    @DisplayName("корректно создает бин для конфигурации")
    void shouldCorrectCreateBeanForConfiguration() {
//        doNothing().when(quizService).run(anyString());
//        when(personService.newPerson()).thenReturn(new Person("1", "2"));
//        doNothing().when(questionService).start(any());
//        when(questionService.getQuestions()).thenReturn(any());

        LocalizationConfig config = new LocalizationConfig();

        assertNotNull(config.messageSource());
    }
}
