package com.oneso.quiz.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Параметры в конфигурации")
class PropertiesTest {

    @Autowired
    private PathQuizProperties pathQuizProperties;

    @Autowired
    private UserProperties userProperties;

    @Test
    @DisplayName("достают путь до файла")
    void shouldGetPathToFile() {
        assertEquals("test", pathQuizProperties.getCsv());
    }

    @Test
    @DisplayName("изменяет путь до файла")
    void shouldReplacePathToFile() {
        pathQuizProperties.setCsv("123");

        assertEquals("123", pathQuizProperties.getCsv());
    }

    @Test
    @DisplayName("достают локаль")
    void shouldGetLocale() {
        assertNotNull(userProperties.getLocale());
    }

    @Test
    @DisplayName("изменяют локаль")
    void shouldReplaceLocal() {
        userProperties.setLocale("test");

        assertEquals("test", userProperties.getLocale());
    }
}
