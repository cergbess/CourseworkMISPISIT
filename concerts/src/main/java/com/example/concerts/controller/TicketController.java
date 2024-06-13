package com.example.concerts.controller;

import com.example.concerts.model.Ticket;
import com.example.concerts.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping({"/viewTicketList"})
    public String viewTicketList(@ModelAttribute("message")String message, Model model){
        getTicketsByFullName("", model);
        model.addAttribute("ticketList",ticketService.getAllTickets());
        model.addAttribute("message", message);
        return "ViewTicketList";
    }
    @GetMapping({"/AddTicket"})
    public String AddTicket(@ModelAttribute("message") String message,Model model){
        model.addAttribute("ticket",new Ticket());
        model.addAttribute("message",message);
        return "AddTicket";
    }

    @PostMapping("/saveTicket")
    public String saveTicket(Ticket ticket, RedirectAttributes redirectAttributes) {
        try {
            ticketService.saveOrUpdateTicket(ticket);
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewTicketList";
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("message", "Save Failure");
            redirectAttributes.addFlashAttribute("errorMsg", ex.getMessage());
            return "redirect:/AddTicket";
        }
    }

    @GetMapping("/editTicket/{id}")
    public String editTicket(@PathVariable Long id, Model model){
        model.addAttribute("ticket",ticketService.getTicketById(id));
        return "EditTicket";
    }
    @PostMapping("/editSaveTicket")
    public String editSaveTicket(Ticket ticket, RedirectAttributes redirectAttributes) {
        if (ticketService.saveOrUpdateTicket(ticket)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewTicketList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editTicket/" + ticket.getId();
    }
    @GetMapping("/deleteTicket/{id}")
    public String deleteTicket(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (ticketService.deleteTicket(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewTicketList";
    }
    @GetMapping("/getTicketsByFullName")
    public String getTicketsByFullName(@RequestParam(value = "ticketcategory", required = false) String ticketcategory, Model model) {
        List<Ticket> tickets;
        if (ticketcategory != null && !ticketcategory.isEmpty()) {
            tickets = ticketService.getTicketsByTicketCategory(ticketcategory);
        } else {
            tickets = ticketService.getAllTickets();
        }

        if (tickets != null) {
            model.addAttribute("message", "Get Success");
        } else {
            model.addAttribute("error", "Get Failure");
        }
        model.addAttribute("tickets", tickets);
        return "ViewTicketList";
    }

    @GetMapping("/calculatePrice")
    @ResponseBody
    public Integer calculatePrice(@RequestParam("concertName") String concertName,
                                 @RequestParam("ticketCategory") String ticketCategory) {

        String artistName = ticketService.getArtistName(concertName);
        String sceneName = ticketService.getSceneName(concertName);

        double basePrice = ticketService.calculateTicketPrice(artistName,sceneName);

        double categoryMultiplier = 1.0;
        if (ticketCategory.equals("VIP")) {
            categoryMultiplier = 1.5;
        } else if (ticketCategory.equals("Standart")) {
            categoryMultiplier = 1.3;
        } else if (ticketCategory.equals("Dance Floor")) {
            categoryMultiplier = 1.2;
        }
        double finalPrice = basePrice * categoryMultiplier;

        return (int) Math.round(finalPrice);
    }
}
