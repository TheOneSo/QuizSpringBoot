package com.oneso.quiz.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Опросник")
class QuestionsTest {

    @Test
    @DisplayName("коррекстно создается")
    void shouldCorrectCreator() {
        Questions questions1 = new Questions(new HashMap<String, String>() {{put("test1", "test");}});
        Questions questions2 = new Questions("test1", "test");

        Map<String, String> temp = new HashMap<String, String>(){{put("test1", "test");}};

        assertEquals(temp, questions1.getQuestions());
        assertEquals(temp, questions2.getQuestions());
    }

    @Test
    @DisplayName("добавляет новый вопрос")
    void shouldAddNewQuestion() {
        Questions questions = new Questions("1", "2");
        questions.addQuestion("2", "3");

        assertEquals(2, questions.getQuestions().size());

    }

    @Test
    @DisplayName("не создает повторяющийся вопрос")
    void shouldNotCreatDoubleQuestion() {
        Questions questions = new Questions("1", "2");
        questions.addQuestion("1", "2");

        assertEquals(1, questions.getQuestions().size());
    }
}
