package pl.krysiukm.milionarequiz.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Question implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    private Answer correctAnswer;

    @OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    private List<Answer> incorrectAnswers;

    @JsonIgnoreProperties
    private Difficulty difficulty;
}
