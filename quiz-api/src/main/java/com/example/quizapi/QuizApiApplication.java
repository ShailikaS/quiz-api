package com.example.quizapi;

import com.example.quizapi.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApiApplication {

	private final QuestionService service;

	public QuizApiApplication(QuestionService service) {
		this.service = service;
	}

	public static void main(String[] args) {

		 SpringApplication.run(QuizApiApplication.class, args);
	}

	@PostConstruct
	public void init() {
		service.fetchAndSaveQuestions();
	}

}
