package com.example.demo2;

import com.example.demo2.models.Answer;
import com.example.demo2.models.Question;
import com.example.demo2.models.Test;
import com.example.demo2.repositoryes.TestRepository;
import com.example.demo2.services.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Demo2Application.class, args);
//        TestService testService = run.getBean(TestService.class);
//
//        List<Answer> answers = new ArrayList<>();
//        answers.add(new Answer(0,"тру", true));
//        answers.add(new Answer(0,"фолс", false));
//        answers.add(new Answer(0,"фолс", false));
//        answers.add(new Answer(0,"фолс", false));
//        List<Answer> answers1 = new ArrayList<>();
//        answers1.add(new Answer(0,"тру", true));
//        answers1.add(new Answer(0,"фолс", false));
//        answers1.add(new Answer(0,"фолс", false));
//        answers1.add(new Answer(0,"фолс", false));
//        List<Question> questions = new ArrayList<>();
//        questions.add(new Question(0,"Вопрос 1", answers));
//        questions.add(new Question(0,"Вопрос 12", answers1));
//        Test test = new Test(0, "Тест 1", 0.7f, questions);
//        testService.saveTest(test);


    }

}
