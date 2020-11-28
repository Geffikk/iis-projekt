package org.forum.controller;

import org.forum.entities.Section;
import org.forum.entities.user.User;
import org.forum.newform.NewSectionForm;
import org.forum.service.SectionService;
import org.forum.service.UserService;
import org.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@ComponentScan
@Controller
@RequestMapping("/section/")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    /** SECTION OVERVIEW **/
    @RequestMapping("{id}")
    public String getTopicsFromSection(@PathVariable int id,
                                       Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("topics", topicService.findBySection(id));
        return "section";
    }

    /** SECTION MODERATORS OVERVIEW **/
    @RequestMapping(value = "{id}/moderators", method = RequestMethod.GET)
    public String getModeratorsOfSection(@PathVariable int id,
                                       Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", sectionService.findOne(id).getModerators());
        return "moderators_and_members_view";
    }


    /** SECTION MEMBERS OVERVIEW **/
    @RequestMapping(value = "{id}/members", method = RequestMethod.GET)
    public String getMembersOfSection(@PathVariable int id, Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", sectionService.findOne(id).getMembers());
        return "moderators_and_members_view";
    }

    /** SECTION MEMBERS OR MODERATORS ADDING VIEW **/
    @RequestMapping(value = "{id}/add", method = RequestMethod.GET)
    public String showUsersToAdd(@PathVariable int id, Model model){
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", userService.findAll());
        return "add";
    }

    /** NEW SECTION OVERVIEW GET METHOD**/
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewSectionForm(Model model) {
        model.addAttribute("newSection", new NewSectionForm());
        return "new_section_form";
    }

    /** CREATE NEW SECTION AND REDIRECT TO THIS SECTION VIEW**/
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String processAndAddNewSection(
            @Valid @ModelAttribute("newSection") NewSectionForm newSkupina,
            BindingResult result,
            Authentication authentication) {

        if (result.hasErrors()) {
            return "new_section_form";
        }
        System.out.println(newSkupina.getIsPublic());

        User user = userService.findByUsername(authentication.getName());

        Section section = new Section();
        section.setName(newSkupina.getName());
        section.setDescription(newSkupina.getDescription());

        if (newSkupina.getIsPublic().toLowerCase().equals("public")) {
            section.setIsPublic(1);
        } else {
            section.setIsPublic(0);
        }
        section.setUser(user);
        section.getModerators().add(user);
        section = sectionService.save(section);
        return "redirect:/section/" + section.getId();
    }


    /** DELETE SECTION **/
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {
        User user = userService.findByUsername(authentication.getName());
// todo tests and checking if user is admin
//        if (!user.getRoles().contains(adminRole)) {
//            return "redirect:/section/" + id;
//        }
        Section section = sectionService.findOne(id);
        if(!user.equals(section.getUser()) || !section.getModerators().contains(user)){
            return "redirect:/section/" + id;
        }

        sectionService.delete(id);

        model.addFlashAttribute("message", "section.successfully.deleted");
        return "redirect:/home";
    }


}
