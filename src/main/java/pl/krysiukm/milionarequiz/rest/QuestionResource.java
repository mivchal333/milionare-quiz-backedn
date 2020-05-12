package pl.krysiukm.milionarequiz.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.krysiukm.milionarequiz.bean.QuestionBean;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;
import pl.krysiukm.milionarequiz.rest.exception.BadRequestResponseException;
import pl.krysiukm.milionarequiz.rest.validators.QuestionResourceValidator;
import pl.krysiukm.milionarequiz.service.BeanHelper;
import pl.krysiukm.milionarequiz.service.QuestionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/question")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionResource {
    private final QuestionService questionService;
    private final QuestionResourceValidator validator;
    private final BeanHelper beanHelper;

    @RequestMapping("/difficulty")
    ResponseEntity<List<QuestionBean>> getQuestions(@RequestParam(defaultValue = "NORMAL", name = "difficulty") String difficultyParam) {
        Difficulty difficulty = validator.validateDifficulty(difficultyParam);
        List<Question> questions = questionService.readPackage(difficulty);

        List<QuestionBean> beans = questions.stream()
                .map(beanHelper::getQuestionBean)
                .collect(Collectors.toList());

        return ResponseEntity.ok(beans);
    }

    @RequestMapping("/{id}")
    ResponseEntity<QuestionBean> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.getQuestion(id);
        if (!question.isPresent()) {
            throw new BadRequestResponseException();
        }

        QuestionBean bean = beanHelper.getQuestionBean(question.get());

        return ResponseEntity.ok(bean);
    }
}
