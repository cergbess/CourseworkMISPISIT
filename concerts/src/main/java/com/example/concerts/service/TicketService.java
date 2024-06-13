package com.example.concerts.service;

import com.example.concerts.model.Artist;
import com.example.concerts.model.Concert;
import com.example.concerts.model.Scene;
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

    @Autowired
    private SceneService sceneService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ConcertService concertService;

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
    public boolean saveOrUpdateTicket(Ticket ticket) throws RuntimeException {
        try {
            ticketrepo.save(ticket);
            return true;
        } catch (Exception e) {
            if (e.getCause() != null && e.getCause().getCause() != null) {
                String message = e.getCause().getCause().getMessage();
                if (message.contains("Total tickets sold exceeds available scene seats")) {
                    throw new RuntimeException("Total tickets sold exceeds available scene seats");
                } else {
                    throw new RuntimeException(message);
                }
            }
            throw new RuntimeException("An unknown error occurred");
        }
    }
    public boolean deleteTicket(Long id) {
        ticketrepo.deleteById(id);
        if (ticketrepo.findById(id) != null) {
            return true;
        }
        return false;
    }

    public List<Ticket> getTicketsByConcertName(String concertName) {
        return ticketrepo.findByConcertName(concertName);
    }

    public String getArtistName(String concertName){

        Concert concert = concertService.getConcertsByConcertName(concertName);

        return concert.getArtistId();
    }
    public String getSceneName(String concertName){

        Concert concert = concertService.getConcertsByConcertName(concertName);

        return concert.getSceneId();
    }

    public Double calculateTicketPrice(String artistName, String sceneName) {
        Artist artist = artistService.getArtistsByFullName(artistName);

        Scene scene = sceneService.getScenesBySceneName(sceneName);

        if (artist != null && scene != null) {
            double price = (scene.getPricePerPerformance() + artist.getFeeAmount()) /
                    (scene.getAudienceSeats() * artist.getPopularityIndex() * 0.01);

            return price;
        } else {
            return null;
        }
    }


}
