package pl.krysiukm.milionarequiz.service;

import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.bean.QuestionBean;
import pl.krysiukm.milionarequiz.model.Answer;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.model.Question;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeanHelper {
    public QuestionBean getQuestionBean(Question question) {
        QuestionBean bean = new QuestionBean();
        bean.setId(question.getId());
        bean.setQuestion(question.getQuestion());

        List<String> incorrectQuestions = question.getIncorrectAnswers().stream()
                .map(Answer::getContent)
                .collect(Collectors.toList());
        bean.setIncorrectAnswers(incorrectQuestions);

        Difficulty difficulty = question.getDifficulty();
        bean.setDifficulty(difficulty.toString());

        bean.setCorrectAnswer(question.getCorrectAnswer().getContent());

        return bean;
    }
}
