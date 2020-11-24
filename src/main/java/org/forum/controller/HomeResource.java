package org.forum.controller;

import org.forum.service.PostService;
import org.forum.service.SectionService;
import org.forum.service.TopicService;
import org.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan
@Controller
public class HomeResource {

//    @RequestMapping("/")
//    public String home() {
//        return "teraz";
//    }
//    @GetMapping
//    public ModelAndView main(Model model) {
//        model.addAttribute("post", new Post());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index.html");
//        return modelAndView;
//    }
//
//    @PostMapping
//    public ModelAndView save(Post post, Model model) {
//        model.addAttribute("post", post);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("saved.html");
//        return modelAndView;
//    }

    @Autowired
    private SectionService sectionService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/home" })
    public String home(Model model) {
        model.addAttribute("sections", sectionService.findAll());
        model.addAttribute("topics", topicService.findRecent());
        model.addAttribute("posts", postService.findRecent());
        return "home";
    }

    @RequestMapping("/navbar")
    public String navbar(Model model) {
        model.addAttribute("sections", sectionService.findAll());
        model.addAttribute("topics", topicService.findRecent());
        model.addAttribute("posts", postService.findRecent());
        return "fragments/navbar";
    }
}