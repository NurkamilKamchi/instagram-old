package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo {
    String signUp (User user);
    User signIn(User user);
    List<User> getAllUsers();

    Optional<User> findById(Long userId);

}
