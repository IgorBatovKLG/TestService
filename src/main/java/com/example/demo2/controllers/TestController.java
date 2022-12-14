package com.example.demo2.controllers;

import com.example.demo2.models.Answer;
import com.example.demo2.models.Question;
import com.example.demo2.models.Test;
import com.example.demo2.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/add_test")
    public String addTest(Model model){
        model.addAttribute("test", new Test());
        return "add_test";
    }

    @PostMapping("/add_test")
    public String addTest(Test test){
        testService.saveTest(test);
        return "redirect:/";
    }

    @GetMapping("/list_tests")
    public String listTests(Model model){
        model.addAttribute("tests", testService.findAll());
        return "list_tests";
    }

    @GetMapping("/test/{idTest}")
    public String test(@PathVariable("idTest") int id, Model model){
        model.addAttribute("test", testService.find(id));
        return "questions_in_test";
    }

    @GetMapping("/test/{idTest}/{idQuestion}")
    public String question(@PathVariable("idTest") int idTest, @PathVariable("idQuestion") int idQuestion, Model model){
        Test test = testService.find(idTest);
        if (idQuestion == 0){
            model.addAttribute("answer1", "");
            model.addAttribute("answer2", "");
            model.addAttribute("answer3", "");
            model.addAttribute("answer4", "");
            model.addAttribute("question", "");
            model.addAttribute("idQuestion", idQuestion);
            return "question_in_test";
        }
        Question questionGood = test.getQuestions().stream().filter(question -> question.getId() == idQuestion).findFirst().get();
        questionGood.getAnswers().sort((o1, o2) -> o1.getId() - o2.getId());
        model.addAttribute("answer1", questionGood.getAnswers().get(0).getText());
        model.addAttribute("answer2", questionGood.getAnswers().get(1).getText());
        model.addAttribute("answer3", questionGood.getAnswers().get(2).getText());
        model.addAttribute("answer4", questionGood.getAnswers().get(3).getText());
        model.addAttribute("question", questionGood.getText());
        model.addAttribute("idQuestion", idQuestion);
        model.addAttribute("idTest", idTest);
        return "question_in_test";
    }

    @GetMapping("/save-answer")
    public String saveAnswer(@RequestParam(name = "answer1", required = false, defaultValue = "") String answer1,
                             @RequestParam(name = "answer2", required = false, defaultValue = "") String answer2,
                             @RequestParam(name = "answer3", required = false, defaultValue = "") String answer3,
                             @RequestParam(name = "answer4", required = false, defaultValue = "") String answer4,
                             @RequestParam(name = "idQuestion", required = false, defaultValue = "") int idQuestion,
                             @RequestParam(name = "question", required = false, defaultValue = "") String question,
                                @RequestParam(name = "idTest", required = false, defaultValue = "") int idTest,
                             Model model){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(0, answer1, true));
        answers.add(new Answer(0, answer2, false));
        answers.add(new Answer(0, answer3, false));
        answers.add(new Answer(0, answer4, false));
        testService.saveQuestion(answers, idQuestion, question, idTest);
        return "redirect:/test/" + idTest;
    }


}


