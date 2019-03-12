package com.oneso.quiz.service;

import com.oneso.quiz.dao.QuestionDao;
import com.oneso.quiz.domain.Questions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DisplayName("Сервис по работе с вопросами")
class QuestionServiceTest {

    @Mock
    private QuestionDao questionDao;
    @Mock
    private LocalizationService localizationService;

    private QuestionService service;

    @BeforeEach
    void setUp() {
        questionDao = mock(QuestionDao.class);
        when(questionDao.parsQuestionCSV(isNull())).thenReturn(new Questions("1", "2"));
        when(questionDao.parsQuestionCSV(anyString())).thenReturn(new Questions("1", "2"));
        service = new QuestionServiceImpl(questionDao, localizationService);
    }

    @Test
    @DisplayName("парсит и вовращает вопросы")
    void getQuestionsTest() {
        assertNotNull(service.getQuestions());
    }
}
