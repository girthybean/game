package com.appsflyer.game.entities;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @CsvBindByName(column = "question")
    private String question;

    @Column(nullable = false)
    @CsvBindByName(column = "answer")
    private String answer;

    @Column(nullable = false)
    @CsvBindByName(column = "hint")
    private String hint;

    @ManyToMany(mappedBy = "questions")
    private List<Game> games;
}
