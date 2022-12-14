package com.example.demo2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers_users")
public class AnswersUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "id_test")
    private int idTest;
    @Column(name = "id_question")
    private int idQuestion;
    @Column(name = "id_answer")
    private int idAnswer;
    @Column(name = "is_correct")
    private boolean isCorrect;

}
