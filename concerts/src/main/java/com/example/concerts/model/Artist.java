package com.example.concerts.model;
import javax.persistence.*;

@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "managerfullname")
    private String managerFullName;

    @Column(name = "contactinfo", nullable = false)
    private String contactInfo;

    @Column(name = "popularityindex", nullable = false)
    private Integer popularityIndex;

    @Column(name = "feeamount", nullable = false)
    private Double feeAmount;

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getManagerFullName() {
        return managerFullName;
    }

    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(Integer popularityIndex) {
        this.popularityIndex = popularityIndex;
    }

    public Double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Double feeAmount) {
        this.feeAmount = feeAmount;
    }
}