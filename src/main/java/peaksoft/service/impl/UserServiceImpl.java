package peaksoft.service.impl;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.entities.Follower;
import peaksoft.entities.Image;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserRepo;
import peaksoft.service.UserService;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    public static User currentUser;
    public static Long currentUserId;

    @Override
    public String signUp(User user) {
        return userRepo.signUp(user);
    }

    @Override
    public User signIn(User user) {
        currentUser = userRepo.signIn(user);
        currentUserId=user.getId();
        return currentUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public User findById(Long userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
