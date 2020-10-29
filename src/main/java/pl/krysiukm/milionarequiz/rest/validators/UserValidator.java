package pl.krysiukm.milionarequiz.rest.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.repository.UserRepository;
import pl.krysiukm.milionarequiz.rest.exception.BadRequestResponseException;

@Component
@Slf4j
public class UserValidator {
    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateRegistrationAttempt(User user) {
        if (StringUtils.isEmpty(user.getUsername())
                || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getNick())
                || userRepository.findById(user.getUsername()).isPresent()) {
            throw new BadRequestResponseException();
        }
    }

    public boolean validateUserCredentials(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) return false;
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }
}
