package com.example.concerts.repo;

import com.example.concerts.model.TechnicalRider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITechnicalRiderRepository extends JpaRepository<TechnicalRider, Long> {
    List<TechnicalRider> findByArtistId(Integer artistid);
}