package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.repository.UserInfoRepo;
import peaksoft.repository.UserRepo;
import peaksoft.service.UserInfoService;

@Repository
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepo userInfoRepo;
    @Override
    public String saveUserInfo(Long userInfoId,UserInfo userInfo) {
        return userInfoRepo.saveUserInfo(userInfoId,userInfo);
    }

    @Override
    public String deleteUserInfo(Long id) {
        return null;
    }

    @Override
    public String deleteImageByUserInfoId(Long userInfoId) {
        return userInfoRepo.deleteImageByUserInfoId(userInfoId);
    }
}
