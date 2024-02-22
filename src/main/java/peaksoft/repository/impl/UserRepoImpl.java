package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Follower;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String signUp(User user) {
        UserInfo userInfo = new UserInfo();
        Follower follower = new Follower();

        follower.setUser(user);
        user.setFollower(follower);

        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        entityManager.persist(user);
        return "sdf";
    }

    @Override
    public User signIn(User user) {
        try {
            for (User allUser : getAllUsers()) {
                if (allUser.getPassword().equals(user.getPassword()) && allUser.getUserName().equals(user.getUserName())) {
                    return allUser;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
       return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }



}
