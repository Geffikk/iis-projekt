package org.forum.controller;

import org.forum.entity.Skupina;
import org.forum.entity.Uzivatel;
import org.forum.newform.NewSkupinaForm;
import org.forum.service.SkupinaService;
import org.forum.service.UzivatelService;
import org.forum.service.VlaknoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/section/")
public class SkupinaController {

    @Autowired
    private SkupinaService skupinaService;

    @Autowired
    private VlaknoService vlaknoService;

    @Autowired
    private UzivatelService uzivatelService;

    @RequestMapping("{id}")
    public String getVlaknaFromSkupina(@PathVariable int id,
                                       Model model) {
        model.addAttribute("skupina", skupinaService.findOne(id));
        model.addAttribute("vlakna", vlaknoService.findOne(id));
        return "skupina";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewSectionForm(Model model) {
        model.addAttribute("newSkupina", new NewSkupinaForm());
        return "new_skupina_form";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String processAndAddNewSection(
            @Valid @ModelAttribute("newSkupina") NewSkupinaForm newSkupina,
            BindingResult result) {

        if (result.hasErrors()) {
            return "new_skupina_form";
        }

        Skupina skupina = new Skupina();
        skupina.setNazov(newSkupina.getNazov());
        skupina.setPopis(newSkupina.getPopis());
        skupina = skupinaService.save(skupina);
        return "redirect:/skupina/" + skupina.getId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {
        Uzivatel uzivatel = uzivatelService.findByUzivatelskeMeno(authentication.getName());
// todo tests and checking if user is admin
//        if (!user.getRoles().contains(adminRole)) {
//            return "redirect:/section/" + id;
//        }
        skupinaService.delete(id);

        model.addFlashAttribute("message", "skupina.uspesne.vymazana");
        return "redirect:/home";
    }


}
