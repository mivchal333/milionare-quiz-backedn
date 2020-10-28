package pl.krysiukm.milionarequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krysiukm.milionarequiz.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
