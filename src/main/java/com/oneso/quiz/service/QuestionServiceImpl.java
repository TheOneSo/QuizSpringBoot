package com.oneso.quiz.service;

import com.oneso.quiz.dao.QuestionDao;
import com.oneso.quiz.domain.Questions;
import com.oneso.quiz.logger.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Scanner;

@MyLogger
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao qDao;

    private final LocalizationService localizationService;

    @Value("${path.quiz.csv}")
    private String pathToCSV;

    @Autowired
    public QuestionServiceImpl(QuestionDao qDao, LocalizationService localizationService) {
        this.qDao = qDao;
        this.localizationService = localizationService;
    }

    public Questions getQuestions() {
        return qDao.parsQuestionCSV(pathToCSV);
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
