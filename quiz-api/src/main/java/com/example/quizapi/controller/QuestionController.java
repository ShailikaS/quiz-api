package com.example.quizapi.controller;

import com.example.quizapi.model.AnswerDTO;
import com.example.quizapi.model.Question;
import com.example.quizapi.model.QuestionDTO;
import com.example.quizapi.repository.QuestionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/play")
public class QuestionController {
    private final QuestionRepository repository;

    public QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<QuestionDTO> getQuestion() {
        List<Question> questions = repository.findAll();
        if (!questions.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(questions.size());
            Question question = questions.get(index);
            return ResponseEntity.ok(new QuestionDTO(question.getId(), question.getQuestion()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/next")
    public ResponseEntity<Map<String, Object>> submitAnswer(@RequestBody AnswerDTO answerDTO) {
        Optional<Question> questionOptional = repository.findById(answerDTO.getQuestionId());
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            Map<String, Object> response = new HashMap<>();
            if (question.getAnswer().equalsIgnoreCase(answerDTO.getAnswer())) {
                response.put("correct_answer", question.getAnswer());
                List<Question> questions = repository.findAll();
                int index = questions.indexOf(question);
                Question nextQuestion = null;
                if (index + 1 < questions.size()) {
                    nextQuestion = questions.get(index + 1);
                }
                QuestionDTO nextQuestionDTO = nextQuestion == null ? null : new QuestionDTO(nextQuestion.getId(), nextQuestion.getQuestion());
                response.put("next_question", nextQuestionDTO);
                return ResponseEntity.ok(response);
            } else {
                response.put("correct_answer", question.getAnswer());
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
