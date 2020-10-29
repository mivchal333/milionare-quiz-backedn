package pl.krysiukm.milionarequiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {

        return userRepository.save(user);
    }
}
