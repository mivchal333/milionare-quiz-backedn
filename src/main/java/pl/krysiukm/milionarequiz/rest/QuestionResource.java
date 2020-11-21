package pl.krysiukm.milionarequiz.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.bean.QuestionBean;
import pl.krysiukm.milionarequiz.model.Question;
import pl.krysiukm.milionarequiz.rest.exception.BadRequestResponseException;
import pl.krysiukm.milionarequiz.service.BeanHelper;
import pl.krysiukm.milionarequiz.service.QuestionService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/question")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionResource {
    private final QuestionService questionService;
    private final BeanHelper beanHelper;

    @RequestMapping
    ResponseEntity<List<QuestionBean>> getQuestions() {
        List<Question> questions = questionService.getQuestions();

        List<QuestionBean> beans = questions.stream()
                .map(beanHelper::getQuestionBean)
                .collect(Collectors.toList());

        Collections.shuffle(beans);
        int maxQuestionsLength = 12;
        if (beans.size() > maxQuestionsLength) {
            beans = beans.subList(0, maxQuestionsLength);
        }
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

    @PostMapping
    ResponseEntity<Question> importQuestion(@RequestBody QuestionBean questionBean) {
        Question question = beanHelper.getQuestion(questionBean);
        Question updated = questionService.saveQuestion(question);

        return ResponseEntity.ok(updated);
    }
}
