package com.oneso.quiz.service;

import com.oneso.quiz.config.PathQuizProperties;
import com.oneso.quiz.dao.QuestionDao;
import com.oneso.quiz.domain.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao qDao;

    private final LocalizationService localizationService;

    private final PathQuizProperties prop;

    @Autowired
    public QuestionServiceImpl(QuestionDao qDao, LocalizationService localizationService, PathQuizProperties prop) {
        this.qDao = qDao;
        this.localizationService = localizationService;
        this.prop = prop;
    }

    public Questions getQuestions() {
        return qDao.parsQuestionCSV(prop.getCsv());
    }

    public void start(Questions questions) {
        Map<String, String> question = questions.getQuestions();

        int current = 0;

        System.out.println(localizationService.getMessage("welcome.quiz", new Object[] {question.size()}));

        Scanner in = new Scanner(System.in);

        for(Map.Entry<String, String> entry : question.entrySet()) {

            System.out.printf("%s: %s ", localizationService.getMessage("question"), entry.getKey());

            String temp = in.nextLine().trim();

            if(temp.toLowerCase().equals(entry.getValue().toLowerCase().trim())) {
                current++;
            }
        }

        System.out.println(localizationService.getMessage("finnal.quiz", new Object[] {current}));
    }
}
