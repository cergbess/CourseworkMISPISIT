package com.example.concerts.service;

import com.example.concerts.model.TechnicalRider;
import com.example.concerts.repo.ITechnicalRiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnicalRiderService {
    @Autowired
    ITechnicalRiderRepository technicalriderrepo;
    public List<TechnicalRider> getTechnicalRidersByArtist(Integer artistid) {
        return technicalriderrepo.findByArtistId(artistid);
    }
    public List<TechnicalRider> getAllTechnicalRiders(){
        List<TechnicalRider> technicalriderList = new ArrayList<>();
        technicalriderrepo.findAll().forEach(technicalrider -> technicalriderList.add(technicalrider));
        return  technicalriderList;
    }
    public TechnicalRider getTechnicalRiderById(Long id){
        return technicalriderrepo.findById(id).get();
    }
    public boolean saveOrUpdateTechnicalRider(TechnicalRider technicalrider) {
        TechnicalRider updatedTechnicalRider = technicalriderrepo.save(technicalrider);
        if (technicalriderrepo.findById(updatedTechnicalRider.getId()) != null) {
            return true;
        }
        return false;
    }
    public boolean deleteTechnicalRider(Long id) {
        technicalriderrepo.deleteById(id);
        if (technicalriderrepo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
