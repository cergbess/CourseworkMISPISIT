package com.example.concerts.repo;

import com.example.concerts.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByFullName(String fullname);
}
