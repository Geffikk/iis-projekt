package org.forum.controller;

import org.forum.entity.DatabaseOperations;
import org.forum.entity.Post;
import org.forum.entity.Uzivatel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping({ "/", "/index" })
public class HomeResource {

    @GetMapping
    public ModelAndView main(Model model) {
        model.addAttribute("post", new Post());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(Post post, Model model) {
        model.addAttribute("post", post);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saved.html");
        return modelAndView;
    }

}
