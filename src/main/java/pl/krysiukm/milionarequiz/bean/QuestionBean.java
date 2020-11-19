package pl.krysiukm.milionarequiz.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@JsonAutoDetect
@Data
@Builder
@AllArgsConstructor
public class QuestionBean {
    @JsonIgnoreProperties
    private Long id;
    private String question;
    private List<String> incorrectAnswers;
    private String correctAnswer;
    @JsonIgnoreProperties
    private String difficulty;
}
