package peaksoft.service;

import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

@Repository
public interface UserInfoService {
     String saveUserInfo(Long userInfoId,UserInfo userInfo);
    public String deleteUserInfo(Long id);
    String deleteImageByUserInfoId(Long userInfoId);
}
