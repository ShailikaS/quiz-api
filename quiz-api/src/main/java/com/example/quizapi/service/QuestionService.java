package com.example.quizapi.service;

import com.example.quizapi.model.Question;
import com.example.quizapi.repository.QuestionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class QuestionService {
    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public void fetchAndSaveQuestions() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jservice.io/api/random?count=5";
        ResponseEntity<Question[]> response = restTemplate.getForEntity(url, Question[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            Arrays.stream(response.getBody()).forEach(repository::save);
        }
    }
}
