package peaksoft.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entities.User;
import peaksoft.entities.UserInfo;
import peaksoft.service.UserService;
import peaksoft.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/instagram")
@RequiredArgsConstructor
public class RegistrationController {
//    public static Long currentUserId;
    private final UserService userService;
    @GetMapping
    public String getChoice() {
        return "instagram";
    }
    @GetMapping("/preLogin")
    public String Login(Model model) {
        model.addAttribute("newUser", new User());
        return "sign-in";
    }
    @GetMapping("/login")
    public String signIn(@ModelAttribute("newUser") User user) {
        try {
            for (User allUser : userService.getAllUsers()) {
                if (allUser.getUserName().equals(user.getUserName()) && allUser.getPassword().equals(user.getPassword())) {
                    userService.signIn(allUser);
                    return "home-page";
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/instagram";
    }
    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/sign-up";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.signUp(user);
        return "/instagram";
    }
    @GetMapping("/profile")
    public String profilePage(Model model) {
        model.addAttribute("currentUser", UserServiceImpl.currentUser);
        return "profile-page" ;
    }
    @GetMapping("/home")
    public String getHomePage(){
        return "home-page";
    }

}