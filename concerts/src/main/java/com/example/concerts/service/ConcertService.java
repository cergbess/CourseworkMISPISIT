package com.example.concerts.service;

import com.example.concerts.model.Concert;
import com.example.concerts.repo.IConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcertService {
    @Autowired
    IConcertRepository concertrepo;
    public List<Concert> getConcertsByConcertName(String concertname) {
        return concertrepo.findByConcertName(concertname);
    }
    public List<Concert> getAllConcerts(){
        List<Concert> concertList = new ArrayList<>();
        concertrepo.findAll().forEach(concert -> concertList.add(concert));
        return  concertList;
    }
    public Concert getConcertById(Long id){
        return concertrepo.findById(id).get();
    }
    public boolean saveOrUpdateConcert(Concert concert) {
        Concert updatedConcert = concertrepo.save(concert);
        if (concertrepo.findById(updatedConcert.getId()) != null) {
            return true;
        }
        return false;
    }
    public boolean deleteConcert(Long id) {
        concertrepo.deleteById(id);
        if (concertrepo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
