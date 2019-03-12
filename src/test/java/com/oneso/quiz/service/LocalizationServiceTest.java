package com.oneso.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DisplayName("Сервис по работе с локализацией")
class LocalizationServiceTest {

    @Mock
    private MessageSource messageSource;

    private LocalizationServiceImpl service;

    @BeforeEach
    void setUp() {
        messageSource = mock(MessageSource.class);
        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("test");
        when(messageSource.getMessage(anyString(), isNull(), any(Locale.class))).thenReturn("test");
    }

    @Test
    @DisplayName("корректно создается")
    void shouldCorrectCreator() {
        service = new LocalizationServiceImpl(messageSource);

        assertNotNull(service);
    }

    @Test
    @DisplayName("меняет язык")
    void shouldSwitchLanguage() {
        service = new LocalizationServiceImpl(messageSource);
        service.setLocale("ru", "RU");

        assertEquals("ru", service.getLanguage());

        service.setLocale("en", "US");

        assertEquals("en", service.getLanguage());
    }

    @Test
    @DisplayName("возвращает отформатированное сообщение")
    void shouldReturnFormattedMessage() {
        service = new LocalizationServiceImpl(messageSource);

        service.setLocale("ru", "RU");

        assertNotNull(service.getMessage("test"));
        assertNotNull(service.getMessage("test", new Object[] {"1"}));
    }

    @Test
    @DisplayName("вызывает методы getMessage с нужными параметрами")
    void shouldExecuteMethodsGetMessage() {
        service = new LocalizationServiceImpl(messageSource);
        service.setLocale("en", "US");
        service.getMessage("test");
        verify(messageSource, times(1)).getMessage("test", null, Locale.US);
    }

}
