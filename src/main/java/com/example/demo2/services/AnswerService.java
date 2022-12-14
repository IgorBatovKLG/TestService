package com.example.demo2.services;

import com.example.demo2.models.Question;
import com.example.demo2.models.Test;
import com.example.demo2.repositoryes.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Test find(int id) {
        Test test = answerRepository.find(id);
        List<Question> collect = test.getQuestions().stream().distinct().collect(Collectors.toList());
        test.setQuestions(collect);
        return test;
    }
}
