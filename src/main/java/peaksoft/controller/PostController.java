package peaksoft.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Post;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/postControl")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/newPost")
    public String createPost( Model model) {
        Post post = new Post();
        model.addAttribute("newPosts", post);
        return "addPosts";
    }

    @PostMapping("/savePosts/{userId}/{postImage}")
    public String savePosts(@ModelAttribute("foundPosts") Post post,
                            @PathVariable Long userId,
                            @PathVariable String postImage) {
        postService.savePost(userId,post,postImage);
        return "/profile-page";
    }
}
//@PostMapping("/saveUserInfo/{userInfoId}")
//    public String saveUserInfo(@ModelAttribute("foundUserInfo")UserInfo userInfo,
//                               @PathVariable Long userInfoId){
//        userInfoService.saveUserInfo(userInfoId, userInfo);
//        return "redirect:/instagram/profile";
//    }
