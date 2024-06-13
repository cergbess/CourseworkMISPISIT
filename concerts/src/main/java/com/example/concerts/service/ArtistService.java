package com.example.concerts.service;

import com.example.concerts.model.Artist;
import com.example.concerts.repo.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    IArtistRepository artistrepo;
    public Artist getArtistsByFullName(String fullname) {
        return artistrepo.findByFullName(fullname);
    }
    public List<Artist> getAllArtists(){
    List<Artist> artistList = new ArrayList<>();
    artistrepo.findAll().forEach(artist -> artistList.add(artist));
        return  artistList;
}
public Artist getArtistById(Long id){
    return artistrepo.findById(id).get();
}
public boolean saveOrUpdateArtist(Artist artist) {
    Artist updatedArtist = artistrepo.save(artist);
    if (artistrepo.findById(updatedArtist.getId()) != null) {
        return true;
    }
    return false;
}
    public boolean deleteArtist(Long id) {
       artistrepo.deleteById(id);
        if (artistrepo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
