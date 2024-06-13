package com.example.concerts.model;

import javax.persistence.*;

@Entity
@Table(name = "technicalriders")
public class TechnicalRider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "artistid")
    private String artistId;

    @Column(name = "concertname", nullable = false)
    private String concertName;

    @Column(name = "scenesize", nullable = false)
    private String sceneSize;

    @Column(name = "lightingdevices", nullable = false)
    private Integer lightingDevices;

    @Column(name = "soundsystems", nullable = false)
    private Integer soundSystems;

    @Column(name = "specialeffectsanddecorations", nullable = false)
    private String specialEffectsAndDecorations;

    @Column(name = "workerscount", nullable = false)
    private Integer workersCount;

    @Column(name = "maxexpense", nullable = false)
    private Double maxExpense;

    public TechnicalRider() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public String getSceneSize() {
        return sceneSize;
    }

    public void setSceneSize(String sceneSize) {
        this.sceneSize = sceneSize;
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

    public Integer getWorkersCount() {
        return workersCount;
    }

    public void setWorkersCount(Integer workersCount) {
        this.workersCount = workersCount;
    }

    public Double getMaxExpense() {
        return maxExpense;
    }

    public void setMaxExpense(Double maxExpense) {
        this.maxExpense = maxExpense;
    }
}

