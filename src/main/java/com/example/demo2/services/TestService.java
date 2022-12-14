package com.example.demo2.services;

import com.example.demo2.models.Answer;
import com.example.demo2.models.Question;
import com.example.demo2.models.Test;
import com.example.demo2.repositoryes.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestRepository testRepository;

    public void saveTest(Test test) {
        testRepository.save(test);
        log.info("Test saved: " + test.getName());
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Test find(int id) {
        Test test = testRepository.find(id);
        List<Question> collect = test.getQuestions().stream().distinct().collect(Collectors.toList());
        test.setQuestions(collect);
        return test;
    }

    public void saveQuestion(List<Answer> answers, int idQuestion, String question, int idTest) {
        testRepository.updateOrAddQuestion(idQuestion, answers, question, idTest);

    }
}
