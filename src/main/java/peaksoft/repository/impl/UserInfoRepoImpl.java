package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserInfoRepo;
import peaksoft.service.UserService;
import peaksoft.service.impl.UserServiceImpl;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserInfoRepoImpl implements UserInfoRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveUserInfo(Long userInfoId,UserInfo userInfo1) {
        UserInfo userInfo = entityManager.find(UserInfo.class, userInfoId);
        userInfo.setFullName(userInfo1.getFullName());
        userInfo.setBiography(userInfo1.getBiography());
        userInfo.setGender(userInfo1.getGender());
        userInfo.setImage(userInfo1.getImage());
        entityManager.merge(userInfo);
        return "Success!!!";
    }

    @Override
    public String deleteUserInfo(Long id) {
        return null;
    }
    @Override
    public String deleteImageByUserInfoId(Long userInfoId) {
        UserInfo userInfo = entityManager.find(UserInfo.class, userInfoId);
        userInfo.setImage("null");
        System.out.println("Error!!!");
        return "Success!!";
    }
}
