package com.profdev.nightclubs.nightclubsreport.models;

import com.profdev.nightclubs.nightclubsreport.dao.Visit;

import javax.persistence.*;

@Entity
@Table(name = "visits")
public class Visits implements Visit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private int id;

    @Column(name = "visitorId")
    @JoinColumn(name = "visitors.visitorId")
    private int visitorId;


    @Column(name = "nightClubId")
    @JoinColumn(name = "nightclubs.nightClubId")
    private int  nightClubId;

    @Override
    public void setNightClubId(int nightClubId) {
        this.nightClubId = nightClubId;
    }

    @Override
    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public int getNightClubId() {
        return this.nightClubId;
    }

    @Override
    public int getVisitorId() {
        return this.visitorId;
    }
}
