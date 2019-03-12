package com.oneso.quiz.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Конфигурация для локали")
class LocalizationConfigTest {

    @Test
    @DisplayName("корректно создает бин для конфигурации")
    void shouldCorrectCreateBeanForConfiguration() {
        LocalizationConfig config = new LocalizationConfig();

        assertNotNull(config.messageSource());
    }
}
