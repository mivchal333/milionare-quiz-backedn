package pl.krysiukm.milionarequiz.rest.validators;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.krysiukm.milionarequiz.model.Difficulty;
import pl.krysiukm.milionarequiz.rest.exception.BadRequestResponseException;

@Component
@Slf4j
public class QuestionResourceValidator {

    public Difficulty validateDifficulty(String difficultyParam) {
        Difficulty difficulty;
        if (StringUtils.isBlank(difficultyParam)) {
            throw new BadRequestResponseException();
        } else {
            try {
                difficulty = Difficulty.valueOf(StringUtils.upperCase(difficultyParam));
            } catch (IllegalArgumentException e) {
                log.warn("Incorrect get questions by difficulty request parameter: {}", e.getMessage());
                throw new BadRequestResponseException();
            }
        }
        return difficulty;
    }
}
