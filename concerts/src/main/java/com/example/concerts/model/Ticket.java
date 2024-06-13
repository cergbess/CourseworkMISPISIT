package com.example.concerts.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "concertid")
    private String concertName;

    @Column(name = "ticketcategory", nullable = false)
    private String ticketCategory;

    @Column(name = "ticketprice", nullable = false)
    private Double ticketPrice;

    @Column(name = "totalticketscount", nullable = false)
    private Integer totalTicketsCount;

    @Column(name = "soldticketscount", nullable = false)
    private Integer soldTicketsCount;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcertId() {
        return concertName;
    }

    public void setConcertId(String concertId) {
        this.concertName = concertId;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTotalTicketsCount() {
        return totalTicketsCount;
    }

    public void setTotalTicketsCount(Integer totalTicketsCount) {
        this.totalTicketsCount = totalTicketsCount;
    }

    public Integer getSoldTicketsCount() {
        return soldTicketsCount;
    }

    public void setSoldTicketsCount(Integer soldTicketsCount) {
        this.soldTicketsCount = soldTicketsCount;
    }
}