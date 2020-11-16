package org.forum.controller;

import org.forum.service.UzivatelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UzivatelController {

    @Autowired
    private UzivatelService uzivatelService;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("listOfUzivatelia", uzivatelService.getAllUzivatelov());
        return "index";
    }

}
