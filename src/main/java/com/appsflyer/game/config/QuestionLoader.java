package com.appsflyer.game.config;

import com.appsflyer.game.entities.Question;
import com.appsflyer.game.repository.QuestionRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionLoader {

    @Bean
    public List<Question> loadQuestions(QuestionRepository repository) throws IOException {

        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/questions.csv"));
            CSVReader csvReader = new CSVReader(reader)) {
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(csvReader)
                .withType(Question.class)
                .build();
             return repository.saveAll(csvToBean.parse());
        }
    }
}
