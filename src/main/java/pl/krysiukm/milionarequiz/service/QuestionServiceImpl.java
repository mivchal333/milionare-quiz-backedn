package pl.krysiukm.milionarequiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;
import pl.krysiukm.milionarequiz.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions(Difficulty difficulty) {
        return questionRepository.findAllByDifficulty(difficulty);
    }

    @Override
    public Optional<Question> getQuestion(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestions(Difficulty difficulty, int limit) {
        Page<Question> questionsPage = questionRepository.findAll(PageRequest.of(0, limit));
        return questionsPage.getContent();
    }
}
