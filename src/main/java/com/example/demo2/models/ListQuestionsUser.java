package com.example.demo2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "list_answers_users")
public class ListQuestionsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "id_test")
    private int idTest;
    @Column(name="id_questions")
    private String listIdQuestions;
}
