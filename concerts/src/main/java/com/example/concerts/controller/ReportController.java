package com.example.concerts.controller;

import com.example.concerts.model.Concert;
import com.example.concerts.model.Ticket;
import com.example.concerts.service.ConcertService;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    ConcertService concertService;
    @Autowired
    TicketService ticketService;

    @GetMapping({"/viewReportList"})
    public String viewReportList(@ModelAttribute("message")String message, Model model){
        model.addAttribute("concertList",concertService.getAllConcerts());
        model.addAttribute("message", message);
        return "report";
    }

    @GetMapping("/getReportByFullName")
    public String getReportByFullName(@RequestParam(value = "concertname", required = false) String concertname, Model model) {
        List<Concert> concerts;
        List<Ticket> tickets;
        if (concertname != null && !concertname.isEmpty()) {
            concerts = Collections.singletonList(concertService.getConcertsByConcertName(concertname));
            tickets = ticketService.getTicketsByConcertName(concertname);
            model.addAttribute("message", "Get Success");
        } else {
            concerts = null;
            tickets = null;
            model.addAttribute("message", "Get Failure");
        }
        model.addAttribute("concerts", concerts);
        model.addAttribute("tickets",tickets);

        return "report";
    }
}

