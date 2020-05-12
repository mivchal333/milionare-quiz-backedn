package pl.krysiukm.milionarequiz.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Question implements Serializable {
    @Id
    private Long id;

    private String question;

    @ManyToOne
    private Answer correctAnswer;

    @OneToMany(targetEntity = Answer.class)
    private List<Answer> incorrectAnswers;

    private Difficulty difficulty;
}
