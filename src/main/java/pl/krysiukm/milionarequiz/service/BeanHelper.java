package pl.krysiukm.milionarequiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.bean.HistoryEntryBean;
import pl.krysiukm.milionarequiz.bean.QuestionBean;
import pl.krysiukm.milionarequiz.model.*;
import pl.krysiukm.milionarequiz.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeanHelper {
    private final UserRepository userRepository;

    @Autowired
    public BeanHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public QuestionBean getQuestionBean(Question question) {
        QuestionBean bean = new QuestionBean();
        bean.setId(question.getId());
        bean.setQuestion(question.getQuestion());

        List<String> incorrectQuestions = question.getIncorrectAnswers().stream()
                .map(Answer::getContent)
                .collect(Collectors.toList());
        bean.setIncorrectAnswers(incorrectQuestions);

        Difficulty difficulty = question.getDifficulty();
        if (difficulty != null) {
            bean.setDifficulty(difficulty.toString());
        }

        bean.setCorrectAnswer(question.getCorrectAnswer().getContent());

        return bean;
    }

    public Question getQuestion(QuestionBean questionBean) {
        Question question = new Question();
        question.setQuestion(questionBean.getQuestion());

        question.setCorrectAnswer(new Answer(questionBean.getCorrectAnswer()));

        question.setIncorrectAnswers(
                questionBean.getIncorrectAnswers()
                        .stream()
                        .map(Answer::new)
                        .collect(Collectors.toList()));
        return question;
    }

    public HistoryEntry getHistoryEntry(HistoryEntryBean bean) {
        HistoryEntry historyEntry = new HistoryEntry();
        String username = bean.getUsername();
        Optional<User> userOpt = userRepository.findByUsername(username);
        userOpt.ifPresent(historyEntry::setUser);
        Integer prizeInt = bean.getPrize();
        Prize prize = Prize.fromInteger(prizeInt);
        historyEntry.setPrize(prize);
        return historyEntry;
    }
}
