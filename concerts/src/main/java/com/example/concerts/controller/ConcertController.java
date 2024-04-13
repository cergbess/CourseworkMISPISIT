package com.example.concerts.controller;

import com.example.concerts.model.Concert;
import com.example.concerts.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ConcertController {
    @Autowired
    ConcertService concertService;

    @GetMapping({"/viewConcertList"})
    public String viewConcertList(@ModelAttribute("message")String message, Model model){
        getConcertsByFullName("", model);
        model.addAttribute("concertList",concertService.getAllConcerts());
        model.addAttribute("message", message);
        return "ViewConcertList";
    }
    @GetMapping({"/AddConcert"})
    public String AddConcert(@ModelAttribute("message") String message,Model model){
        model.addAttribute("concert",new Concert());
        model.addAttribute("message",message);
        return "AddConcert";
    }

    @PostMapping("/saveConcert")
    public String saveConcert(@ModelAttribute Concert concert, RedirectAttributes redirectAttributes) {
        if (concertService.saveOrUpdateConcert(concert)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewConcertList";
        }
        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/AddConcert";
    }

    @GetMapping("/editConcert/{id}")
    public String editConcert(@PathVariable Long id, Model model){
        model.addAttribute("concert",concertService.getConcertById(id));
        return "EditConcert";
    }
    @PostMapping("/editSaveConcert")
    public String editSaveConcert(Concert concert, RedirectAttributes redirectAttributes) {
        if (concertService.saveOrUpdateConcert(concert)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewConcertList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editConcert/" + concert.getId();
    }
    @GetMapping("/deleteConcert/{id}")
    public String deleteConcert(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (concertService.deleteConcert(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewConcertList";
    }
    @GetMapping("/getConcertsByFullName")
    public String getConcertsByFullName(@RequestParam(value = "concertname", required = false) String concertname, Model model) {
        List<Concert> concerts;
        if (concertname != null && !concertname.isEmpty()) {
            concerts = concertService.getConcertsByConcertName(concertname);
        } else {
            concerts = concertService.getAllConcerts();
        }

        if (concerts != null) {
            model.addAttribute("message", "Get Success");
        } else {
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("concerts", concerts);
        return "ViewConcertList";
    }
}
