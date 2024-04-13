package com.example.concerts.repo;

import com.example.concerts.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByConcertName(String concertname);
}
