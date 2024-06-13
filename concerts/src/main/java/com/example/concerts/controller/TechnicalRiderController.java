package com.example.concerts.controller;

import com.example.concerts.model.TechnicalRider;
import com.example.concerts.service.TechnicalRiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class TechnicalRiderController {
    @Autowired
    TechnicalRiderService technicalriderService;

    @GetMapping({"/viewTechnicalRiderList"})
    public String viewTechnicalRiderList(@ModelAttribute("message")String message, Model model){
        getTechnicalRidersByFullName("", model);
        model.addAttribute("technicalriderList",technicalriderService.getAllTechnicalRiders());
        model.addAttribute("message", message);
        return "ViewTechnicalRiderList";
    }
    @GetMapping({"/AddTechnicalRider"})
    public String AddTechnicalRider(@ModelAttribute("message") String message,Model model){
        model.addAttribute("technicalrider",new TechnicalRider());
        model.addAttribute("message",message);
        return "AddTechnicalRider";
    }

    @PostMapping("/saveTechnicalRider")
    public String saveTechnicalRider(TechnicalRider technicalrider, RedirectAttributes redirectAttributes){
        if (technicalriderService.saveOrUpdateTechnicalRider(technicalrider)){
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewTechnicalRiderList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/AddTechnicalRider";
    }

    @GetMapping("/editTechnicalRider/{id}")
    public String editTechnicalRider(@PathVariable Long id, Model model){
        model.addAttribute("technicalrider",technicalriderService.getTechnicalRiderById(id));
        return "EditTechnicalRider";
    }
    @PostMapping("/editSaveTechnicalRider")
    public String editSaveTechnicalRider(TechnicalRider technicalrider, RedirectAttributes redirectAttributes) {
        if (technicalriderService.saveOrUpdateTechnicalRider(technicalrider)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewTechnicalRiderList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editTechnicalRider/" + technicalrider.getId();
    }
    @GetMapping("/deleteTechnicalRider/{id}")
    public String deleteTechnicalRider(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (technicalriderService.deleteTechnicalRider(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewTechnicalRiderList";
    }
    @GetMapping("/getTechnicalRidersByArtist")
    public String getTechnicalRidersByFullName(@RequestParam(value = "artistid", required = false) String artistid, Model model) {
        List<TechnicalRider> technicalriders;
        if (artistid != null && !artistid.isEmpty()) {
            technicalriders = technicalriderService.getTechnicalRidersByArtist(artistid);
        } else {
            technicalriders = technicalriderService.getAllTechnicalRiders();
        }

        if (technicalriders != null) {
            model.addAttribute("message", "Get Success");
        } else {
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("technicalriders", technicalriders);
        return "ViewTechnicalRiderList";
    }
}
