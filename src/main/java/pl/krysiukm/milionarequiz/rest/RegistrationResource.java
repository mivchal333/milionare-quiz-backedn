package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.rest.validators.UserValidator;
import pl.krysiukm.milionarequiz.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationResource {
    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationResource(UserValidator userValidator, RegistrationService registrationService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        userValidator.validateRegistrationAttempt(user);
        return registrationService.registerUser(user);
    }
}
