package com.example.quizapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;
    private int value;
    private LocalDateTime airdate;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Long category_id;
    private Long game_id;
    private Integer invalid_count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getAirdate() {
        return airdate;
    }

    public void setAirdate(LocalDateTime airdate) {
        this.airdate = airdate;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public Integer getInvalid_count() {
        return invalid_count;
    }

    public void setInvalid_count(Integer invalid_count) {
        this.invalid_count = invalid_count;
    }


}
