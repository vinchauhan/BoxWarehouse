package com.vchauhan.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.jar.Attributes;

/**
 * Created by Vineet on 9/16/16.
 */
@Entity
@Table(name = "BOX")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOX_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "BOX_CODE", nullable = false, unique = false)
    private String boxCode;

    @Column(name = "BOX_DETAILS", nullable = true, unique = false)
    private String boxDetails;

    @Column(name = "BOX_SIZE", nullable = true, unique = false)
    private String boxSize;

    @Column(name = "SCANNED_ON", nullable = false, unique = false)
    private Date scannedOn;

    @Column(name = "SCANNED_FORMAT", nullable = true, unique = false)
    private String scannedFormat;


    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public Box() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getBoxDetails() {
        return boxDetails;
    }

    public void setBoxDetails(String boxDetails) {
        this.boxDetails = boxDetails;
    }

    public String getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(String boxSize) {
        this.boxSize = boxSize;
    }

    public Date getScannedOn() {
        return scannedOn;
    }

    public void setScannedOn(Date scannedOn) {
        this.scannedOn = scannedOn;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getScannedFormat() {
        return scannedFormat;
    }

    public void setScannedFormat(String scannedFormat) {
        this.scannedFormat = scannedFormat;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxCode='" + boxCode + '\'' +
                ", boxDetails='" + boxDetails + '\'' +
                ", boxSize='" + boxSize + '\'' +
                ", scannedOn=" + scannedOn +
                ", user=" + user +
                '}';
    }

//    @JsonProperty
//    public Long getUserId(){
//        return user== null ? null: user.getId();
//    }
}
