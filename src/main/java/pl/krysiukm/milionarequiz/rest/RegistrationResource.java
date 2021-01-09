package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.rest.validators.UserValidator;
import pl.krysiukm.milionarequiz.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegistrationResource {
    private final UserValidator userValidator;
    private final UserService userService;

    @Autowired
    public RegistrationResource(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        userValidator.validateRegistrationAttempt(user);
        return userService.registerUser(user);
    }
}
