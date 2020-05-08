package pl.krysiukm.milionarequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krysiukm.milionarequiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
