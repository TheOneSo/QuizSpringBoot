package com.oneso.quiz.service;

import com.oneso.quiz.config.UserProperties;
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

    @Mock
    private UserProperties prop;

    private LocalizationServiceImpl service;

    @BeforeEach
    void setUp() {
        messageSource = mock(MessageSource.class);
        prop = mock(UserProperties.class);
        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class))).thenReturn("test");
        when(messageSource.getMessage(anyString(), isNull(), any(Locale.class))).thenReturn("test");
        when(prop.getLocale()).thenReturn("en US");
    }

    @Test
    @DisplayName("корректно создается")
    void shouldCorrectCreator() {
        service = new LocalizationServiceImpl(messageSource, prop);

        assertNotNull(service);
    }

    @Test
    @DisplayName("меняет язык")
    void shouldSwitchLanguage() {
        service = new LocalizationServiceImpl(messageSource, prop);
        service.setLocale("ru", "RU");

        assertEquals("ru", service.getLanguage());

        service.setLocale("en", "US");

        assertEquals("en", service.getLanguage());
    }

    @Test
    @DisplayName("возвращает отформатированное сообщение")
    void shouldReturnFormattedMessage() {
        service = new LocalizationServiceImpl(messageSource, prop);

        service.setLocale("ru", "RU");

        assertNotNull(service.getMessage("test"));
        assertNotNull(service.getMessage("test", new Object[] {"1"}));
    }

    @Test
    @DisplayName("вызывает методы getMessage с нужными параметрами")
    void shouldExecuteMethodsGetMessage() {
        service = new LocalizationServiceImpl(messageSource, prop);
        service.setLocale("en", "US");
        service.getMessage("test");
        verify(messageSource, times(1)).getMessage("test", null, Locale.US);
    }

}
