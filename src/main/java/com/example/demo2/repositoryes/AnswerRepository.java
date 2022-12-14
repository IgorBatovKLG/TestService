package com.example.demo2.repositoryes;

import com.example.demo2.models.AnswersUser;
import com.example.demo2.models.Test;
import org.springframework.stereotype.Repository;


public interface AnswerRepository {


    void saveAnswer(AnswersUser answersUser);

    Test find(int id);
}
