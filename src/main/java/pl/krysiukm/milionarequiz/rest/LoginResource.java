package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.rest.validators.UserValidator;

@RestController
@RequestMapping("/login")
public class LoginResource {

    private final UserValidator userValidator;

    @Autowired
    public LoginResource(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity login(@RequestBody User user) {
        return userValidator.validateUserCredentials(user) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
