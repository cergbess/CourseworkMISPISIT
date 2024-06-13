package com.example.concerts.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "artistid", nullable = false)
    private String artistId;

    @Column(name = "sceneid", nullable = false)
    private String sceneId;

    @Column(name = "concertname", nullable = false)
    private String concertName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "concertdatetime", nullable = false)
    private LocalDateTime concertDateTime;

    @Column(name = "audiencecount", nullable = false)
    private Integer audienceCount;

    @Column(name = "passed", nullable = false)
    private Boolean passed;

    public Concert() {
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

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public LocalDateTime getConcertDateTime() {
        return concertDateTime;
    }

    public void setConcertDateTime(LocalDateTime concertDateTime) {
        this.concertDateTime = concertDateTime;
    }

    public Integer getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(Integer audienceCount) {
        this.audienceCount = audienceCount;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }
}
