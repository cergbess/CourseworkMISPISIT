package com.example.concerts.repo;

import com.example.concerts.model.Scene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ISceneRepository extends JpaRepository<Scene, Long> {
    List<Scene> findBySceneName(String scenename);
}
