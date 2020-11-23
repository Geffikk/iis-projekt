package org.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeResource {

    @RequestMapping("/")
    public String home() {
        return "teraz";
    }
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

}
