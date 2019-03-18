package com.oneso.quiz.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:test.properties")
@ContextConfiguration(classes = QuestionDaoTest.class)
@DisplayName("Дао для работы с вопросами")
class QuestionDaoTest {

    @Value("${path.csv}")
    private String path;

    @Test
    @DisplayName("парсится корректно")
    void shouldDocumentCorrectPars() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.parsQuestionCSV(path);

        assertFalse(questionDaoSimple.getAllQuestions().isEmpty());
    }

    @Test
    @DisplayName("создается корректно")
    void shouldCorrectCreator() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        assertNotNull(questionDaoSimple.parsQuestionCSV(path));
    }

    @Test
    @DisplayName("добавляет 1 вопрос")
    void shouldAddNewQuestion() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.addQuestion("1", "2");

        assertNotNull(questionDaoSimple.getAllQuestions());
    }

    @Test
    @DisplayName("возвращает пустой опросник в место ошибок")
    void shouldReturnNotExceptionInEmptyQuestions() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        assertNotNull(questionDaoSimple.getAllQuestions());
    }

    @Test
    @DisplayName("не позволяет добавить вопрос без ответа и наоборот")
    void shouldNotAddNotFullQuiz() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.addQuestion("1", null);

        assertEquals(0, questionDaoSimple.getAllQuestions().size());

        questionDaoSimple.addQuestion(null, "1");

        assertEquals(0, questionDaoSimple.getAllQuestions().size());
    }

    @Test
    @DisplayName("не парсит документ с кривым путем")
    void createQuestionsFailPath() throws NullPointerException {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        Throwable throwable = assertThrows(NullPointerException.class, () ->
            questionDaoSimple.parsQuestionCSV("1") );

        assertNotNull(throwable);
    }
}
