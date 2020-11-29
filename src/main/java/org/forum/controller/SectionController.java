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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("{id}")
    public String getTopicsFromSection(@PathVariable int id,
                                       Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("topics", topicService.findBySection(id));
        return "section/section";
    }

    @RequestMapping(value = "{id}/moderators", method = RequestMethod.GET)
    public String getModeratorsOfSection(@PathVariable int id,
                                       Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", sectionService.findOne(id).getModerators());
        return "section/moderators";
    }

    @RequestMapping(value = "{id}/members", method = RequestMethod.GET)
    public String getMembersOfSection(@PathVariable int id, Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", sectionService.findOne(id).getMembers());
        return "section/members";
    }

    @RequestMapping(value = "{id}/add/member", method = RequestMethod.GET)
    public String addMembersToSection(@PathVariable int id, Model model){
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", userService.findAll());
        return "section/add_member";
    }

    @RequestMapping(value = "{id}/add/moderator", method = RequestMethod.GET)
    public String addModeratorsToSection(@PathVariable int id, Model model){
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("users", userService.findAll());
        return "section/add_moderator";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewSectionForm(Model model) {
        model.addAttribute("newSection", new NewSectionForm());
        return "section/new_section_form";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String processAndAddNewSection(
            @Valid @ModelAttribute("newSection") NewSectionForm newSkupina,
            BindingResult result,
            Authentication authentication) {

        if (result.hasErrors()) {
            return "section/new_section_form";
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
        section = sectionService.save(section);
        return "redirect:/section/" + section.getId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {
        User user = userService.findByUsername(authentication.getName());
// todo tests and checking if user is admin
//        if (!user.getRoles().contains(adminRole)) {
//            return "redirect:/section/" + id;
//        }
        sectionService.delete(id);

        model.addFlashAttribute("message", "section.successfully.deleted");
        return "redirect:/home";
    }

    @RequestMapping(value = "delete/user/{id_S}/{id_U}", method = RequestMethod.GET)
    public String deleteUserFromSection(@PathVariable Integer id_S,
                                        @PathVariable Integer id_U) {

        // todo tests and checking if user is admin
        //        if (!user.getRoles().contains(adminRole)) {
        //            return "redirect:/section/" + id;
        //        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Section section = sectionService.findOne(id_S);
        User user = userService.findOne(id_U);
        sectionService.deleteUserInCurrentSection(auth, user, section, id_S);

        return "redirect:/section/"+section.getId()+"/members";
    }

    @RequestMapping(value = "add/member/{id_S}/{id_U}", method = RequestMethod.POST)
    public String addMemberToSection(@PathVariable Integer id_S, @PathVariable Integer id_U, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findOne(id_U);
        Section section = sectionService.findOne(id_S);
        sectionService.addUserInCurrentSection(auth, user, section, id_S);

        return "redirect:/section/"+section.getId()+"/members";
    }

    @RequestMapping(value = "add/moderator/{id_S}/{id_U}", method = RequestMethod.POST)
    public String addModeratorToSection(@PathVariable Integer id_S, @PathVariable Integer id_U, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findOne(id_U);
        Section section = sectionService.findOne(id_S);
        sectionService.addModeratorInCurrentSection(user, section);

        return "redirect:/section/"+section.getId()+"/moderators";
    }
}
