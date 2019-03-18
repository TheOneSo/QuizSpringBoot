package com.oneso.quiz.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Конфигурация для локали")
class LocalizationConfigTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    @DisplayName("корректно создает бин для конфигурации")
    void shouldCorrectCreateBeanForConfiguration() {
        assertNotNull(messageSource);
    }
}
