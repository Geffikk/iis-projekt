package org.forum.controller;

import org.forum.entities.user.User;
import org.forum.entities.user.UserProfile;
import org.forum.entities.user.exception.UserNotFoundException;
import org.forum.newform.ProfilForm;
import org.forum.service.UserProfileService;
import org.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/user/{username}")
    public String findUserByUsernameAndViewProfilePage(@PathVariable String username,
                                                       Model model, Authentication authentication) {
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }

        if (userProfile.getUser().getIsPublic() == 0 && !authentication.getName().equals(username)) {
            return "redirect:/";
        }

        model.addAttribute("userProfile", userProfile);
        return "myprofile";
    }

    @RequestMapping(value = "/users")
    public String listOfAllUser(Model model, @RequestParam(defaultValue="") String name) {
        try {
            model.addAttribute("users", userService.findAllByUsername(name));
        } catch (Exception e) {
            model.addAttribute("users", userService.findAll());
            System.out.println("kokotina");
        }
        return "users";
    }

    @RequestMapping(value = "/myprofile")
    public String myProfile(Authentication authentication,
                            Model model) {
        String username = authentication.getName();
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("profilForm", new ProfilForm());
        return "user";
    }

    @RequestMapping(value = "/myprofile/edit/picture", method = RequestMethod.POST)
    public String processAndSaveProfilePicture(@RequestPart MultipartFile profilePicture,
                                               HttpServletRequest request,
                                               Authentication authentication,
                                               RedirectAttributes redirectModel) {
        if (authentication.getName() == null) {
            return "redirect:/login";
        }
        if (profilePicture.isEmpty()) {
            return "redirect:/myprofile";
        }
        User user = userService.findByUsername(authentication.getName());
        try {
            String path =
                    request.getSession().getServletContext().getRealPath("/resources/public/img/pp/");
            profilePicture.transferTo(new File(path + user.getIdProfilePicture() + ".jpg"));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        userService.save(user);
        redirectModel.addFlashAttribute("message", "user.picture.successfully.saved");
        return "redirect:/myprofile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username or password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logOutAndRedirectToLoginPage(Authentication authentication,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout=true";
    }
}
