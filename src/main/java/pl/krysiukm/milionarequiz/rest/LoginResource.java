package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.rest.validators.UserValidator;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginResource {

    private final UserValidator userValidator;

    @Autowired
    public LoginResource(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @PostMapping
    @ResponseBody
    public Optional<User> login(@RequestBody User user) {
        return userValidator.validateUserCredentials(user);
    }
}
