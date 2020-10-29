package pl.krysiukm.milionarequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krysiukm.milionarequiz.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
