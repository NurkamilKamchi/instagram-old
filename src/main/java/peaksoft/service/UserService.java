package peaksoft.service;

import org.springframework.stereotype.Repository;
import peaksoft.entities.User;

import java.util.List;
@Repository

public interface UserService {
    String signUp (User user);
    User signIn(User user);
    List<User> getAllUsers();

    User findById(Long userId);

}
