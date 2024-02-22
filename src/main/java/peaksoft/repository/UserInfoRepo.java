package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;

@Repository
public interface UserInfoRepo {
     String saveUserInfo(Long userInfoId,UserInfo userInfo);
    public String deleteUserInfo(Long id);
    String deleteImageByUserInfoId(Long userInfoId);
}
