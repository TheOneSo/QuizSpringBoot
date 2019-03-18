package com.oneso.quiz.dao;

import com.oneso.quiz.domain.Questions;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestionDaoSimple implements QuestionDao {

    private Questions questions;

    public Questions parsQuestionCSV(String pathCsv) {
        Map<String, String> out = new HashMap<>();

        try(Reader reader = Files.newBufferedReader(Paths.get(QuestionDaoSimple.class.getResource(pathCsv).toURI()))) {

            CSVReader csvReader = new CSVReader(reader);

            String[] next;
            while ((next = csvReader.readNext()) != null) {
                if(next[0] != null && next[1] != null) {
                    out.put(next[0], next[1]);
                }
            }

        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        questions = new Questions(out);
        return questions;
    }

    public Map<String, String> getAllQuestions() {
        if(questions != null) {
            return questions.getQuestions();
        }

        return new HashMap<>();
    }

    public void addQuestion(String question, String answer) {
        if(question == null || answer == null) {
            return;
        }

        if(questions == null) {
            questions = new Questions(question, answer);
        }

        this.questions.addQuestion(question, answer);
    }
}
