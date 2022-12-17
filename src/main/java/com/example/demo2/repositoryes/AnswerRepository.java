package com.example.demo2.repositoryes;

import com.example.demo2.models.AnsweredQuestions;
import com.example.demo2.models.ListQuestionsUser;
import com.example.demo2.models.Test;


public interface AnswerRepository {


    void saveAnswer(AnsweredQuestions answersUser);

    Test find(int id);

    void createListAnswers(ListQuestionsUser listAnswersUser);
}
