package com.example.demo2.controllers;

import com.example.demo2.models.Question;
import com.example.demo2.models.Test;
import com.example.demo2.models.User;
import com.example.demo2.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/answer-test/{idTest}/{idQuestion}")
    public String answerTest(@AuthenticationPrincipal User user,
                             @PathVariable("idTest") int idTest,
                             @PathVariable("idQuestion") int idQuestion,
                             Model model){
        Test test = answerService.find(idTest);
        Question question = test.getQuestions().get(idQuestion);
        return "redirect:/";
    }
}
