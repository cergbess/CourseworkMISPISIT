package com.example.concerts.service;

import com.example.concerts.model.Ticket;
import com.example.concerts.repo.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    ITicketRepository ticketrepo;
    public List<Ticket> getTicketsByTicketCategory(String ticketcategory) {
        return ticketrepo.findByTicketCategory(ticketcategory);
    }
    public List<Ticket> getAllTickets(){
        List<Ticket> ticketList = new ArrayList<>();
        ticketrepo.findAll().forEach(ticket -> ticketList.add(ticket));
        return  ticketList;
    }
    public Ticket getTicketById(Long id){
        return ticketrepo.findById(id).get();
    }
    public boolean saveOrUpdateTicket(Ticket ticket) {
        Ticket updatedTicket = ticketrepo.save(ticket);
        if (ticketrepo.findById(updatedTicket.getId()) != null) {
            return true;
        }
        return false;
    }
    public boolean deleteTicket(Long id) {
        ticketrepo.deleteById(id);
        if (ticketrepo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
