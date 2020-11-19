package pl.krysiukm.milionarequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.krysiukm.milionarequiz.service.QuestionService;

@SpringBootApplication
public class MillionaireQuizApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(MillionaireQuizApplication.class, args);
        QuestionService bean = run.getBean(QuestionService.class);
        bean.initializeQuestions();
    }

}
