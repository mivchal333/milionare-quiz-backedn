package pl.krysiukm.milionarequiz.service;

import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getQuestions(Difficulty difficulty);

    Optional<Question> getQuestion(Long id);

    List<Question> getQuestions(Difficulty difficulty, int limit);
}
