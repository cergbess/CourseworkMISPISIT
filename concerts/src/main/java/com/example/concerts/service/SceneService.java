package com.example.concerts.service;

import com.example.concerts.model.Scene;
import com.example.concerts.repo.ISceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SceneService {
    @Autowired
    ISceneRepository scenerepo;
    public List<Scene> getScenesBySceneName(String scenename) {
        return scenerepo.findBySceneName(scenename);
    }
    public List<Scene> getAllScenes(){
        List<Scene> sceneList = new ArrayList<>();
        scenerepo.findAll().forEach(scene -> sceneList.add(scene));
        return  sceneList;
    }
    public Scene getSceneById(Long id){
        return scenerepo.findById(id).get();
    }
    public boolean saveOrUpdateScene(Scene scene) {
        Scene updatedScene = scenerepo.save(scene);
        if (scenerepo.findById(updatedScene.getId()) != null) {
            return true;
        }
        return false;
    }
    public boolean deleteScene(Long id) {
        scenerepo.deleteById(id);
        if (scenerepo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
