package com.oneso.quiz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class YamlProperties {

    private PathQuiz pathQuiz = new PathQuiz();
    private User user = new User();

    public PathQuiz getPathQuiz() {
        return pathQuiz;
    }

    public void setQuiz(PathQuiz pathQuiz) {
        this.pathQuiz = pathQuiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public static class PathQuiz {

        private String csv;

        public String getCsv() {
            return csv;
        }

        public void setCsv(String csv) {
            this.csv = csv;
        }
    }

    public static class User {

        private String locale;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }
    }
}
