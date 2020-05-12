package pl.krysiukm.milionarequiz.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@JsonAutoDetect
@Data
public class QuestionBean {
    private Long id;
    private String question;
    private List<String> incorrectAnswers;
    private String correctAnswer;
    private String difficulty;
}
