package com.example.quizapi.model;

public class QuestionDTO {
    private Long questionId;
    private String question;

    public QuestionDTO(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }


}
