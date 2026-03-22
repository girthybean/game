package com.appsflyer.game.config;

import com.appsflyer.game.entities.Question;
import com.appsflyer.game.repository.QuestionRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class QuestionLoader {

    @Bean
    public List<Question> loadQuestions(QuestionRepository repository, ResourceLoader resourceLoader) throws IOException {

        try (Reader reader = new InputStreamReader(resourceLoader.getClassLoader().getResourceAsStream("classpath:questions.csv"), StandardCharsets.UTF_8);
            CSVReader csvReader = new CSVReader(reader)) {
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(csvReader)
                .withType(Question.class)
                .build();
            return repository.saveAll(csvToBean.parse());
        }
    }
}
