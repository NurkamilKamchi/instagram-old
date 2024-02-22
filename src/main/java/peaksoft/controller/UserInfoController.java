package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.service.UserInfoService;
import peaksoft.service.UserService;
import peaksoft.service.impl.UserServiceImpl;

//@RequestParam


@Controller
@RequiredArgsConstructor
@RequestMapping("/userInfo")
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final UserService userService;


    @GetMapping("/newUserInfo/{userId}")
    public String createUserInfo(@PathVariable Long userId, Model model) {
        UserInfo userInfo = userService.findById(userId).getUserInfo();
        model.addAttribute("foundUserInfo", userInfo);
        return "editProfile";
    }

    @PostMapping("/saveUserInfo/{userInfoId}")
    public String saveUserInfo(@ModelAttribute("foundUserInfo") UserInfo userInfo,
                               @PathVariable("userInfoId") Long userInfoId){
//        UserServiceImpl.currentUser = user;
        userInfoService.saveUserInfo(userInfoId,userInfo);
        return "redirect:/instagram/profile";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home-page";
    }

    @PostMapping("/{userInfoId}/delete")
    public String deleteImage(@PathVariable Long userInfoId) {
        userInfoService.deleteImageByUserInfoId(userInfoId);
        return "profile-page";
    }
}
