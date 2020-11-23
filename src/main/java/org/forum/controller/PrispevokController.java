package org.forum.controller;

import org.forum.entity.Prispevok;
import org.forum.service.PrispevokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/prispevok")
public class PrispevokController {

    @Autowired
    private PrispevokService prispevokService;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {
        Prispevok prispevok = prispevokService.findPrispevokById(id);
        if (prispevok == null || authentication == null || authentication.getName() == null
                || !authentication.getName().equals(prispevok.getZakladatelPrispevku().getUzivatelskeMeno())) {
            return "redirect:/";
        }

        prispevokService.delete(prispevok);

        model.addFlashAttribute("message", "prispevok.uspesne.vymazany");
        return "redirect:/topic/" + prispevok.getVlaknoPrispevku().getId();
    }
}
