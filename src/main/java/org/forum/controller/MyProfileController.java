package org.forum.controller;

import org.forum.entities.user.User;
import org.forum.newform.NewSectionForm;
import org.forum.newform.ProfilForm;
import org.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@ComponentScan
@Controller
@RequestMapping("/myprofile/")
public class MyProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute("profilForm") ProfilForm profilForm, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "user";
        }

        User user = new User();
        int ifPublic;

        try {
            user = userService.findByUsername(authentication.getName());
        } catch (Exception e) {
            System.out.println("Uzivatel" + user.getUsername() + "Nebol najdeny");
        }

        if (profilForm.getIsPublic().toLowerCase().equals("public")) {
            ifPublic = 1;
        } else {
            ifPublic = 0;
        }

        user.setIsPublic(ifPublic);
        user = userService.save(user);
        return "redirect:/myprofile/";
    }
}
