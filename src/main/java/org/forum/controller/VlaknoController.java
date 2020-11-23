package org.forum.controller;

import org.forum.entity.Prispevok;
import org.forum.entity.Vlakno;
import org.forum.newform.NewPrispevokFrom;
import org.forum.newform.NewVlaknoForm;
import org.forum.service.PrispevokService;
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
@RequestMapping("/vlakno/")
public class VlaknoController {

    @Autowired
    private PrispevokService prispevokService;

    @Autowired
    private VlaknoService vlaknoService;

    @Autowired
    private SkupinaService skupinaService;

    @Autowired
    private UzivatelService uzivatelService;

    @RequestMapping(value = "{idVlakna}", method = RequestMethod.GET)
    public String getVlaknoById(@PathVariable int  idVlakna, Model model) {

        Vlakno vlakno = vlaknoService.findOne(idVlakna);
        vlakno.setPohlady(vlakno.getPohlady() + 1);
        vlaknoService.save(vlakno);

        model.addAttribute("vlakno", vlakno);
        model.addAttribute("prispevky", prispevokService.findByVlaknoPrispevku(idVlakna));
        model.addAttribute("newPrispevok", new NewPrispevokFrom());
        return "vlakno";
    }

    @RequestMapping(value = "{idVlakna}", method = RequestMethod.POST)
    public String addPrispevok(@Valid @ModelAttribute("newPrispevok") NewPrispevokFrom newPrispevok,
                               BindingResult result,
                               Authentication authentication,
                               @PathVariable int idVlakna,
                               Model model) {

        if(result.hasErrors()) {
            model.addAttribute("vlakno", vlaknoService.findOne(idVlakna));
            model.addAttribute("prispevky", prispevokService.findByVlaknoPrispevku(idVlakna));
            return "vlakno";
        }

        Prispevok prispevok = new Prispevok();
        prispevok.setObsah(newPrispevok.getContent());
        prispevok.setVlaknoPrispevku(vlaknoService.findOne(idVlakna));
        prispevok.setZakladatelPrispevku(uzivatelService.findByUzivatelskeMeno(authentication.getName()));
        prispevokService.save(prispevok);

        model.asMap().clear();
        return "redirect:/vlakno/" + idVlakna;
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewVlaknoForm(Model model) {
        model.addAttribute("newVlakno", new NewVlaknoForm());
        model.addAttribute("skupiny", skupinaService.findAll());
        return "new_vlakno_form";
    }


    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String processAndAddNewVlakno(@Valid @ModelAttribute("newVlakno") NewVlaknoForm newVlakno,
                                         BindingResult result,
                                         Authentication authentication,
                                         Model model) {

        if(result.hasErrors()) {
            model.addAttribute("skupiny", skupinaService.findAll());
            return "new_vlakno_form";
        }

        Vlakno vlakno = new Vlakno();
        vlakno.setZakladatelVlakna(uzivatelService.findByUzivatelskeMeno(authentication.getName()));
        vlakno.setPredmet(newVlakno.getPredmet());
        vlakno.setKontent(newVlakno.getKontent());
        vlakno.setSkupinaVlakna(skupinaService.findOne(newVlakno.getSkupinaId()));
        vlaknoService.save(vlakno);

        return "redirect:/vlakno/" + vlakno.getId();

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {

        Vlakno vlakno = vlaknoService.findOne(id);

        if(vlakno == null) {
            return "redirect:/";
        }
        if(!authentication.getName().equals(vlakno.getZakladatelVlakna().getUzivatelskeMeno())) {
            return "redirect:/vlakno/" + id;
        }

        vlaknoService.delete(vlakno);

        model.addFlashAttribute("message","vlakno.uspesne.vymazane");
        return "redirect:/skupina/" + vlakno.getSkupinaVlakna().getId();
    }

}
