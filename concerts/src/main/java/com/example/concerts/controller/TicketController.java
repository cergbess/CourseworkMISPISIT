package com.example.concerts.controller;

import com.example.concerts.model.Ticket;
import com.example.concerts.service.TicketService;
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
    public String saveTicket(Ticket ticket, RedirectAttributes redirectAttributes){
        if (ticketService.saveOrUpdateTicket(ticket)){
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewTicketList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/AddTicket";
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
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("tickets", tickets);
        return "ViewTicketList";
    }
}
