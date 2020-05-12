package pl.krysiukm.milionarequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByDifficulty(Difficulty difficulty);
}
