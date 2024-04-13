package com.example.concerts.model;

import javax.persistence.*;

@Entity
@Table(name="scenes")
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "scenename", nullable = false)
    private String sceneName;

    @Column(name = "priceperperformance", nullable = false)
    private Double pricePerPerformance;

    @Column(name = "scenesize", nullable = false)
    private String sceneSize;

    @Column(name = "audienceseats", nullable = false)
    private Integer audienceSeats;

    @Column(name = "lightingdevices", nullable = false)
    private Integer lightingDevices;

    @Column(name = "soundsystems", nullable = false)
    private Integer soundSystems;

    @Column(name = "specialeffectsanddecorations", nullable = false)
    private String specialEffectsAndDecorations;

    public Scene() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Double getPricePerPerformance() {
        return pricePerPerformance;
    }

    public void setPricePerPerformance(Double pricePerPerformance) {
        this.pricePerPerformance = pricePerPerformance;
    }

    public String getSceneSize() {
        return sceneSize;
    }

    public void setSceneSize(String sceneSize) {
        this.sceneSize = sceneSize;
    }

    public Integer getAudienceSeats() {
        return audienceSeats;
    }

    public void setAudienceSeats(Integer audienceSeats) {
        this.audienceSeats = audienceSeats;
    }

    public Integer getLightingDevices() {
        return lightingDevices;
    }

    public void setLightingDevices(Integer lightingDevices) {
        this.lightingDevices = lightingDevices;
    }

    public Integer getSoundSystems() {
        return soundSystems;
    }

    public void setSoundSystems(Integer soundSystems) {
        this.soundSystems = soundSystems;
    }

    public String getSpecialEffectsAndDecorations() {
        return specialEffectsAndDecorations;
    }

    public void setSpecialEffectsAndDecorations(String specialEffectsAndDecorations) {
        this.specialEffectsAndDecorations = specialEffectsAndDecorations;
    }
}

