package com.profdev.nightclubs.nightclubsreport.models;

import com.profdev.nightclubs.nightclubsreport.dao.NightClub;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "nightclubs")
public class NightClubs implements NightClub {

    @Id
    @Autowired
    @Column(name = "nightClubId")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private int nightClubId;

    @Column(name = "nightClubName")
    private String nightClubName;

    public NightClubs() {
    }

    public NightClubs(String nightClubName) {
        this.nightClubName = nightClubName;
    }

    @Override
    public String getNightClubName() {
        return this.nightClubName;
    }

    @Override
    public int getNightClubId() {
        return this.nightClubId;
    }

    @Override
    public void setNightClubName(String nightClubName) {
        this.nightClubName = nightClubName;
    }

    @Override
    public String toString() {
        return "[" + "id = " + this.nightClubId + ", nightClubName = " + this.nightClubName +"]";
    }
}