package com.example.demo2.repositoryes;

import com.example.demo2.models.AnsweredQuestions;
import com.example.demo2.models.ListQuestionsUser;
import com.example.demo2.models.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class AnswerRepositoryJpaImpl implements AnswerRepository {

    private final EntityManager em;


    @Override
    public void saveAnswer(AnsweredQuestions answersUser) {
        em.createNativeQuery("insert into answers_users (id_user, id_test, id_question, id_answer, is_correct) values (?,?,?,?,?)")
                .setParameter(1, answersUser.getIdUser())
                .setParameter(2, answersUser.getIdTest())
                .setParameter(3, answersUser.getIdQuestion())
                .setParameter(4, answersUser.getIdAnswer())
                .setParameter(5, answersUser.isCorrect())
                .executeUpdate();
    }

    @Override
    public Test find(int id) {
        return em.find(Test.class, id);
    }

    @Override
    public void createListAnswers(ListQuestionsUser listAnswersUser){
        em.createNativeQuery("insert into list_answers_users (id_user, id_test, id_questions) values (?,?,?)")
                .setParameter(1, listAnswersUser.getIdUser())
                .setParameter(2, listAnswersUser.getIdTest())
                .setParameter(3, listAnswersUser.getListIdQuestions())
                .executeUpdate();
    }

}
